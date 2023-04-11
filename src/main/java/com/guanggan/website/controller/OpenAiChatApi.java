package com.guanggan.website.controller;

/**
 * @NAME: OpenAiChatApi
 * @USER: hongbong
 * @DATE: 2023/4/6
 * @TIME: 18:05
 **/
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.guanggan.website.entity.R;
import com.guanggan.website.entity.Renum;
import com.guanggan.website.utils.RUtils;
import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
import com.guanggan.website.service.OpenAiChatBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
@Slf4j
public class OpenAiChatApi {

    @Autowired
    private OpenAiChatBiz openAiChatBiz;

    @GetMapping("/test")
    public R<String> test(@RequestBody String question){
        return RUtils.success(question);
    }

    /**
     * api聊天
     * @param question
     * @return
     */
    @GetMapping("/question")
    public R<String> openAiChat(@RequestBody String question){
        if(StringUtils.isBlank(question)){
            return RUtils.Err(Renum.API_NOT_MASSAGE.getCode(), Renum.API_NOT_MASSAGE.getMsg());
        }

        String res = openAiChatBiz.chat(question);
        return RUtils.success(res);
    }



}
