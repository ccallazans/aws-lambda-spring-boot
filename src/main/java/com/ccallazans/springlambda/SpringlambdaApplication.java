package com.ccallazans.springlambda;

import com.ccallazans.springlambda.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({UserController.class})
public class SpringlambdaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringlambdaApplication.class, args);
    }
}
