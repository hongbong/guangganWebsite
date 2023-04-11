package com.guanggan.website.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @NAME: User
 * @USER: hongbong
 * @DATE: 2023/4/6
 * @TIME: 12:08
 **/

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    //用户名
    private String username;

    //密码
    private String password;

    //公司名称
    private String company;

    //邮箱
    private String email;

    //手机号
    private String phone;

    //权限
    private Integer power;

}
