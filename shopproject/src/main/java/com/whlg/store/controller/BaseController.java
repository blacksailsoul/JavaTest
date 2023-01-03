package com.whlg.store.controller;

import com.whlg.store.service.ex.*;
import com.whlg.store.utils.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    //定义一个成功状态码的常量
    public static final int OK=200;
 
    //自定义异常拦截
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handlerException(Throwable e){
        //创建结果集对象做异常返回处理
            JsonResult<Void> result=new JsonResult<Void>(e);
            if(e instanceof UserException){
                result.setCode(201);
              //  result.setMessage("用户名重复，请换个名称");
            }else if(e instanceof InsertException){
                result.setCode(202);
              //  result.setMessage("添加失败，请联系管理员");
            }else if(e instanceof PasswordNotMatchException){
                result.setCode(203);
              //  result.setMessage("密码校验失败");
            }else if(e instanceof UpdateException){
                result.setCode(204);
            }else if(e instanceof  SelectException){
                result.setCode(205);
            }else if(e instanceof FileException){
                result.setCode(206);
            }

            return result;
    }
}
