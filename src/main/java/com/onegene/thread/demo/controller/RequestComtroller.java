package com.onegene.thread.demo.controller;

import com.onegene.thread.demo.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName RequestComtroller
 * @Descriiption TODO
 * @Author yanjiantao
 * @Date 2019/2/19 11:41
 **/
@RestController
@Slf4j
public class RequestComtroller {

    @Autowired
    private RequestService requestService;

    @RequestMapping(path = "/request/test")
    public Object requestTest(){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("【controller】--------showRequest------accessToken={}",request.getHeader("accessToken"));
        requestService.test();
        return "success";
    }
}
