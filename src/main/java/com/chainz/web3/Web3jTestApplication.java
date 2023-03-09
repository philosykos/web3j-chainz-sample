package com.chainz.web3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableScheduling
public class Web3jTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Web3jTestApplication.class, args);
    }

}
