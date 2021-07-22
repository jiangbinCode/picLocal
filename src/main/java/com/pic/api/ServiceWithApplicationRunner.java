package com.pic.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @program: picLocal
 * @description:
 * @author: bin
 * @create: 2021-07-22 09:56
 **/
@Component
public class ServiceWithApplicationRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(ServiceWithApplicationRunner.class);

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.info("startRegistrationService...");
        logger.info("Service registration successful,port:80");
        logger.info("=======================================");
        logger.info("Welcome to use gourd baby program, current version :1.0");
        logger.info("author: bin");
        logger.info("=======================================");
    }
}
