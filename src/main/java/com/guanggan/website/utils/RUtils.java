package com.guanggan.website.utils;

import com.guanggan.website.entity.R;
import com.guanggan.website.entity.Renum;

/**
 * @NAME: RUtils
 * @USER: hongbong
 * @DATE: 2023/4/7
 * @TIME: 11:51
 **/
public class RUtils {

    public static R success(Object object) {
        R r = new R();
        r.setCode(Renum.SUCCESS.getCode());
        r.setMsg(Renum.SUCCESS.getMsg());
        r.setData(object);
        return r;
    }
    //成功，但返回体没数据
    public static  R success(){
        return success(null);
    }
    //失败返回信息
    public static R Err(Integer code,String msg){
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }


}
