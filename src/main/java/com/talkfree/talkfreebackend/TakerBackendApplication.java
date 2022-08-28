package com.talkfree.talkfreebackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TakerBackendApplication {

    static Logger logger = LoggerFactory.getLogger(TakerBackendApplication.class);
    public static void main(String[] args) {
        logger.debug("Start the TakerBackend");
        SpringApplication.run(TakerBackendApplication.class, args);
    }

}
