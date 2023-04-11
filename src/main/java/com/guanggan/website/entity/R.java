package com.guanggan.website.entity;

import lombok.Data;

/**
 * @NAME: R 通用返回类
 * @USER: hongbong
 * @DATE: 2023/4/7
 * @TIME: 11:44
 **/

@Data
public class R<T> {
    private Integer code;
    private String msg;
    private T data;
}
