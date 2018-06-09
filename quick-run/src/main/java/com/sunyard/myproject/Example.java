package com.sunyard.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2018/3/28.
 */
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan("com.sunyard.myproject")
//@Profile("qa")
@SpringBootApplication
public class Example {
//    @RequestMapping("/")
//    String home() {
//        return "Hello World!";
//    }

    public static void main(String[] args) throws Exception {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(Example.class, args);
    }
}
