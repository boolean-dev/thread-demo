package com.onegene.thread.demo.service;

import com.onegene.thread.demo.async.RequestAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName RequestService
 * @Descriiption TODO
 * @Author yanjiantao
 * @Date 2019/2/19 11:42
 **/
@Service
@Slf4j
public class RequestService {


    @Qualifier("threadPoolTaskExecutor")
    @Autowired
    private ThreadPoolTaskExecutor threadPool;


    public void test() {


        ServletRequestAttributes attributesMain = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest requestMain = attributesMain.getRequest();
        log.info("main---------------threadId={}",Thread.currentThread().getId());
        log.info("【service-main】--------showRequest------accessToken={}",requestMain.getHeader("accessToken"));

        threadPool.execute(new RequestAsync(attributesMain));
    }
}
