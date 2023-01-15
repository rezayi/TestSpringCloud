package com.mrezaei.admin.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EntityScan("com.mrezaei")
@ComponentScan("com.mrezaei")
@SpringBootApplication
public class AdminProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminProductApplication.class, args);
    }

}
