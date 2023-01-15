package com.mrezaei.admin.product.controllers;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaController implements GreetingController {
    @Lazy
    @Autowired
    private EurekaClient eurekaClient;
    @Value("${spring.application.name}")
    private String appName;

    @Override
    public String greeting() {
        return String.format(
                "Hello from '%s'!", eurekaClient.getApplication(appName).getName());
    }
}
