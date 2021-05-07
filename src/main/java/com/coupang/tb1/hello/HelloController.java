package com.coupang.tb1.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *
 *   @author chkim127
 *   @since
 *
 */
@RestController
public class HelloController {

    @RequestMapping("")
    public String hello(){
        return "hello";
    }
}
