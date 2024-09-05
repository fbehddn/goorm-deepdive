package com.spring.mvcproject.controller;

import com.spring.mvcproject.domain.User;
import com.spring.mvcproject.service.LoggedUserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private LoggedUserManagementService loggedUserManagementService;

//    //http://localhost:8080/user/signup
//    @RequestMapping("/signup")
//    public String signup(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "signup";
//    }
//
//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    @ResponseBody
//    public String signup(@ModelAttribute User user) {
//        System.out.println("user = " + user);
//        return "success";
//    }

    //http://localhost:8080/user/login
    @RequestMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user, Model model) {
        User predefinedUser = new User();

        if (predefinedUser.getEmail().equals(user.getEmail()) &&
            predefinedUser.getPassword().equals(user.getPassword())){
            model.addAttribute("name", user.getName());
            return "loginSuccess";
        }

        return "redirect:/user/login";
    }
}
