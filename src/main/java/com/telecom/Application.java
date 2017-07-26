package com.telecom;

/**
 * Created by huanghua on 2017/5/23.
 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value={"com.telecom"})
@MapperScan("com.telecom.mapper")
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    // for local development, debug in IDE
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}

