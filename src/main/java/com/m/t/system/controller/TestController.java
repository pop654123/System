package com.m.t.system.controller;

import com.m.t.system.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class TestController {

    @RequestMapping("/healthCheck")
    @ResponseBody
    public String home(){
        return "hello world";
    }
    //1. restful api
    //2. html
    //{"code":"","msg":"","data":""}
    @Autowired
    RedisService redisService;
    @RequestMapping(value="/testRedis", method = RequestMethod.GET)
    public String setTest(@RequestParam(value = "key", required = true) String key,
                          @RequestParam(value = "value", required = true) String value){
        redisService.set(key,value);
        log.info("key - value:"+redisService.get(key,String.class));
        return "success";
    }

}
