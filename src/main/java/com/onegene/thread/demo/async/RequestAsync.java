package com.onegene.thread.demo.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName RequestAsync
 * @Descriiption TODO
 * @Author yanjiantao
 * @Date 2019/2/19 11:43
 **/
@Slf4j
public class RequestAsync implements Runnable {


    private ServletRequestAttributes attributes;

    public RequestAsync(ServletRequestAttributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public void run() {
        RequestContextHolder.setRequestAttributes(attributes, true);
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("thread---------------threadId={}",Thread.currentThread().getId());
        log.info("【service-thread】--------showRequest------accessToken={}",request.getHeader("accessToken"));
    }
}
