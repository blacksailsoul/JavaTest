package com.whlg.store.service.impl;

import com.whlg.store.entity.User;
import com.whlg.store.mapper.UserMapper;
import com.whlg.store.service.IUserService;
import com.whlg.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
     private UserMapper userMapper;



    //注册
    @Override
    public void addUser(User user) {
        //传递过来的user中只有用户名,邮箱,密码
        String username=user.getUsername();
        String email=user.getEmail();
        User result1=userMapper.findByUsername(username);
        if(result1!=null){
            throw new UserException("用户名"+username+"重复，请换个用户名");
        }
        User result2=userMapper.findByEmail(email);
        if(result2!=null){
            throw new UserException("邮箱"+email+"重复，请换个邮箱");
        }
        //补全日志信息
        Date now = new Date();
        user.setCreatedUser(username);
        user.setCreatedTime(now);
        user.setChangeUser(username);
        user.setChangeTime(now);

        int rows = userMapper.insertUser(user);
        if (rows != 1) {
            throw new InsertException("注册用户失败，请联系管理员");
        }
    }

    @Override
    public User login(String username, String password) {
        //1.登录时根据用户名查询是否存在该用户，
        User result = userMapper.findByUsername(username);
        if (result == null) {
            throw new UserException("用户数据不存在，请换个帐号试试");
        }
        //2.存在：进行密码校验
        if (!result.getPassword().equals(password)) {
            throw new PasswordNotMatchException("密码验证失败，请重新输入");
        }
        //3.返回结果集登录的用户信息,只返回有用信息
        return result;
    }

    @Override
    public User getPwdBack(String username) {

        //1.根据传递过来的用户名查找
        User result=userMapper.findByUsername(username);
        if(result==null){
            throw new UserException("该用户不存在");
        }
        //2.查找成功时，传递给前端一个User
        return result;
    }

    @Override
    public void editPasswordGetPwdBack(int uid, String newPassword, String conNewPassword) {
        //1.根据传递过来的id查找
        User result=userMapper.findByUid(uid);
        if(result==null){
            throw new UserException("该用户不存在");
        }
        //2.查找到了
        //判断新密码和重复新密码正不正确
        System.out.println("newPassword="+newPassword+",conNewPassword="+conNewPassword);
        if(!newPassword.equals(conNewPassword)){
            throw new PasswordNotMatchException("两次输入的密码不相同，请重新输入");
        }
        //3.两次密码正确更新数据库
        User user=new User();
        user.setUid(uid);
        user.setPassword(newPassword);
        user.setChangeUser(result.getUsername());
        user.setChangeTime(new Date());
        userMapper.UpdatePassword(user);
    }

    @Override
    public void editInfo(User user) {
        //1.根据传递过来的id查找
        User result=userMapper.findByUid(user.getUid());
        if(result==null){
            throw new UserException("该用户不存在");
        }
        int rows=userMapper.updateInfo(user);
        if(rows!=1){
            throw new UpdateException("更新数据失败，请联系管理员");
        }

    }

    @Override
    public void editAddress(int uid, String address) {
        //1.根据传递过来的id查找
        User result=userMapper.findByUid(uid);
        if(result==null){
            throw new UserException("该用户不存在");
        }
        User user=new User();
        user.setUid(uid);
        user.setAddress(address);
        user.setChangeUser(result.getUsername());
        user.setChangeTime(new Date());
        int rows=userMapper.updateAddress(user);
        if(rows!=1){
            throw new UpdateException("更新数据失败，请联系管理员");
        }
    }

    @Override
    public void editPassword(int uid, String oldPassword, String newPassword, String conNewPassword) {
        //1.根据传递过来的id查找
        User result=userMapper.findByUid(uid);
        if(result==null){
            throw new UserException("该用户不存在");
        }
        //核对旧密码和数据库中的密码
        if(!oldPassword.equals(result.getPassword())){
            throw new PasswordNotMatchException("密码不正确,请重新输入");
        }
        //核对新旧密码
        if(!newPassword.equals(conNewPassword)){
            throw new PasswordNotMatchException("两次新密码输入前后不一致");
        }
        User temp=new User();
        temp.setUid(uid);
        temp.setPassword(newPassword);
        temp.setChangeUser(result.getUsername());
        temp.setChangeTime(new Date());
        int rows=userMapper.UpdatePassword(temp);
        if(rows!=1){
            throw new UpdateException("更新数据错误，请联系管理员");
        }
    }

    @Override
    public void editAvatar(int uid, String avatar, String username) {
        User result=userMapper.findByUid(uid);
        if(result==null)
        {
            throw new SelectException("用户数据不存在");
        }
        int rows=userMapper.updateAvatar(uid,avatar,username,new Date());
        if(rows!=1){
            throw new UpdateException("修改头像失败,请联系管理员");
        }
    }

    //更新用户信息

}
