package com.guanggan.website.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;

/**
 * @NAME: MyTest
 * @USER: hongbong
 * @DATE: 2023/4/6
 * @TIME: 14:33
 **/
@Slf4j
public class MyTest {



    @Test
    public void test(){
        String s = "12345678";
        s = DigestUtils.md5DigestAsHex(s.getBytes());
        System.out.println(s);
    }


}
