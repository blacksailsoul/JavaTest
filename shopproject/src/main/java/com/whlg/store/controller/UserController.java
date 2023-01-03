package com.whlg.store.controller;


import com.whlg.store.entity.User;
import com.whlg.store.service.IUserService;
import com.whlg.store.service.ex.FileException;
import com.whlg.store.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.json.Json;
 
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Api(tags = "用户模块")
public class UserController extends BaseController {

    public static final List<String> AVATAR_TYPES=new ArrayList<String>();
    static{
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/gif");
    }
    public static final int  AVATAR_MAX_SIZE=2*1024*1024;


    @Autowired
    private IUserService iUserService;

    @PostMapping("/reg")
    @ApiOperation("注册接口")
    public JsonResult<Void> reg(@RequestBody User user) {
        //调用业务层
        iUserService.addUser(user);
        return new JsonResult<Void>(OK);
    }

    @PostMapping("/login")
    @ApiOperation("登录接口")
    public JsonResult<User> login(String username,String password){
        User user=iUserService.login(username,password);
        return new JsonResult<User>(OK,user);
    }

    @PostMapping("/getPwdBack")
    @ApiOperation("找回密码接口")
    public JsonResult<User> getPwdBack(String username){
        User user=iUserService.getPwdBack(username);
        return new JsonResult<User>(OK,user);
    }

    @PostMapping("/editPwdGetPwdBack")
    @ApiOperation("重置密码（找回密码）接口")
    public JsonResult<Void> editPwdGetPwdBack(int uid,String newPassword,String conNewPassword){
        iUserService.editPasswordGetPwdBack(uid,newPassword,conNewPassword);
        return new JsonResult<Void>(OK);
    }

    @PostMapping("/editInfo")
    @ApiOperation("修改用户信息接口")
    public JsonResult<Void> editInfo(@RequestBody User user){
        iUserService.editInfo(user);
        return new JsonResult<Void>(OK);
    }

    @PostMapping("/editAddress")
    @ApiOperation("修改用户地区接口")
    public JsonResult<Void> editAddress(int uid,String address){
        iUserService.editAddress(uid,address);
        return new JsonResult<Void>(OK);
    }

    @PostMapping("/editPassword")
    @ApiOperation("修改用户密码接口")
    public JsonResult<Void> editPassword(int uid,String oldPassword,String newPassword,String conNewPassword){
        iUserService.editPassword(uid,oldPassword,newPassword,conNewPassword);
        return new JsonResult<Void>(OK);
    }

    @PostMapping("/change_avatar")
    @ApiOperation("用户头像修改")
    public JsonResult<String> changeAvatar(Integer uid, MultipartFile file, String username, HttpSession session){
        System.out.println(uid);

        if(file.isEmpty()){
            throw new FileException("上传头像文件不能为空");
        }

        //1文件上传大小的约束
        if(file.getSize()>AVATAR_MAX_SIZE){
            throw new FileException("上传文件图片不允许超过"+(AVATAR_MAX_SIZE/1024/1024)+"MB");
        }
        //2文件上传类型的约束
        String contentTypes=file.getContentType();
        if(!AVATAR_TYPES.contains(contentTypes)){
            throw new FileException("文件上传类型错误！");
        }
        //3.上传的文件保存在本地服务器，图片地址保存在数据库
        //3.1获取当前项目在磁盘的绝对路径，将图片文件保存在本地磁盘中
        String parent=session.getServletContext().getRealPath("upload");
        File dir=new File(parent);
        if(!dir.exists()){
            //目录不存在
            dir.mkdir();
        }

        //3.2图片地址保存在数据库,获取图片地址的文件名及后缀(随机生成文件名)
        //        获取出整个文件名称
        String fileName = file.getOriginalFilename();
        //        取出 . 的下标
        int index = fileName.lastIndexOf(".");
        String suffix = "";
        //        取出文件后缀
        if(index > 0){
            suffix = fileName.substring(index);
        }
        //        使用UUID生成随机的图片名 + 文件类型后缀
        String newFileName = UUID.randomUUID().toString() + suffix;
        //        保存图片在本地磁盘
        File dest = new File(dir, newFileName);
        try {
            //            图片执行保存
            file.transferTo(dest);
        } catch (IOException e) {
            throw new FileException("上传文件失败，请联系管理员");
        }
        //        3.3图片地址保存在数据库 http://locahost:8080 + /upload/dhajdhaj.jpg
        String avatar = "/upload/" + newFileName;
        //        调用业务层的更新头像的方法
        iUserService.editAvatar(uid, avatar, username);
        //        返回结果集 =》 图片地址
        return new JsonResult<String>(OK, avatar);
    }

}
