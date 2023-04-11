package com.guanggan.website.common;

/**
 * @NAME: BaseContext
 * @USER: hongbong
 * @DATE: 2023/4/7
 * @TIME: 15:33
 **/

/**
 * 基于Thread Local封装工具类，用户保存和获取当前用户权限
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new InheritableThreadLocal<>();

    public static void setCurrentPower(Long power){threadLocal.set(power);}

    public static Long getCurrentPower(){return threadLocal.get();}

}
