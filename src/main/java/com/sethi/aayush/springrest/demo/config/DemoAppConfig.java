package com.sethi.aayush.springrest.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.sethi.aayush.springrest.demo")
public class DemoAppConfig {

}
