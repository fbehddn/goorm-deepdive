package com.spring.mvcproject.controller;

import com.spring.mvcproject.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    //http://localhost:8080/user/signup
    @RequestMapping("/signup")
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    @ResponseBody
    public String signup(@ModelAttribute User user) {
        System.out.println("user = " + user);
        return "success";
    }
}
