package com.guanggan.website.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.guanggan.website.entity.R;
import com.guanggan.website.entity.Renum;
import com.guanggan.website.entity.User;
import com.guanggan.website.service.UserService;
import com.guanggan.website.utils.RUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @NAME: UserController
 * @USER: hongbong
 * @DATE: 2023/4/6
 * @TIME: 13:49
 **/

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/test")
    public R test(){
        return RUtils.Err(Renum.SUCCESS.getCode(), "test成功！");
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public R register(@RequestBody User user){
        //对密码进行md5加密
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,user.getUsername());
        User one = userService.getOne(lambdaQueryWrapper);

        //如果有此用户名，则返回用户名重复
        if(one != null){
            return RUtils.Err(Renum.USER_IS_EXISTS.getCode(),Renum.USER_IS_EXISTS.getMsg());
        }

        //注册成功，将用户信息存入数据库
        user.setPassword(password);
        user.setPower(0);
        userService.save(user);
        log.info("注册成功！用户信息为："+user);
        return RUtils.success(null);
    }


    /**
     * 员工登陆
     * @param user
     * @return
     */
    @PostMapping("/login")
    public R<String> login(HttpServletRequest request, @RequestBody User user){

        //对用户密码进行md5加密
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,user.getUsername());
        User one = userService.getOne(lambdaQueryWrapper);

        //如果没有查到用户名，则返回登陆失败结果
        if(one == null){
            return RUtils.Err(Renum.USER_NOT_EXIST.getCode(),Renum.USER_NOT_EXIST.getMsg());
        }

        //如果密码不对，则返回登陆失败结果
        if(!password.equals(one.getPassword())){
            return RUtils.Err(Renum.PASSWORD_WRONG.getCode(),Renum.PASSWORD_WRONG.getMsg());
        }

        //登录成功，将用户权限存入session中
        request.getSession().setAttribute("power",one.getPower());
        log.info("登录成功！");
        return RUtils.success(null);
    }

}
