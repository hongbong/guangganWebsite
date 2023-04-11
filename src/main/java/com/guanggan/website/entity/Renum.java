package com.guanggan.website.entity;

/**
 * @NAME: Renum 返回枚举类
 * @USER: hongbong
 * @DATE: 2023/4/7
 * @TIME: 11:47
 **/

public enum Renum {
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(200,"成功"),
    //登陆错误
    USER_NOT_EXIST(1,"用户名不存在"),
    PASSWORD_WRONG(2,"用户密码错误"),
    //注册错误
    USER_IS_EXISTS(3,"用户名已存在"),
    //api错误
    API_NOT_MASSAGE(11,"输入文本为空"),
    API_OVERTIME(12,"api请求响应超时");

    private Integer code;
    private String msg;

    Renum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
