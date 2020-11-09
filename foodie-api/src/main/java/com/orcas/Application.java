package com.orcas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author: Orcas
 * @version:1.0.0
 * @date: 2020/9/29 16:35
 */
@SpringBootApplication
@MapperScan(basePackages = "com.orcas.mapper")
@ComponentScan(basePackages = {"com.orcas", "org.n3r.idworker"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
