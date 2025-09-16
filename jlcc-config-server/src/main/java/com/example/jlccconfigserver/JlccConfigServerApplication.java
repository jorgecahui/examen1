package com.example.jlccconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class JlccConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JlccConfigServerApplication.class, args);
    }

}
