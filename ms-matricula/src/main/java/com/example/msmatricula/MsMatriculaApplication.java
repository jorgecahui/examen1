package com.example.msmatricula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsMatriculaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsMatriculaApplication.class, args);
    }

}
