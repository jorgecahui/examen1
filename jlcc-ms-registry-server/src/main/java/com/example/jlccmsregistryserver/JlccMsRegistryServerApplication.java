package com.example.jlccmsregistryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class JlccMsRegistryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JlccMsRegistryServerApplication.class, args);
    }

}
