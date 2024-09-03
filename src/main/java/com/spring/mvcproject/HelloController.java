package com.spring.mvcproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    // http://localhost:8080/hello
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    // http://localhost:8080/requestMappingGetTest
    @RequestMapping(value="/requestMappingGetTest", method= RequestMethod.GET)
    public String requestMappingGetTest(Model model){
        model.addAttribute("textFromControler", "World");
        model.addAttribute("textFromController2", "JJJJJJJJ");
        return "requestHello";
    }
}
