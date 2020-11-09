package com.orcas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author: Orcas
 * @version:1.0.0
 * @date: 2020/9/29 16:39
 */
@RestController
@ApiIgnore
public class HelloController {

    @GetMapping("/hello")
    public Object hello() {
        return "Hello Orcas !!";
    }


}
