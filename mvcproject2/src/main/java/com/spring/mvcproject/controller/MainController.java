package com.spring.mvcproject.controller;

import com.spring.mvcproject.service.LoggedUserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    @Autowired //생성자에 주입되는 객체가 빈으로 등록되어있으면, 자동으로 오토와이어링이 가능해서 어노테이션 제거 가능
    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String mainPage(
            @RequestParam(required = false) String logout, Model model) {

        if (logout != null) { //logout 매개변수가 있다면
            loggedUserManagementService.setUsername(null);
            return "redirect:/user/login";
        }

        String username = loggedUserManagementService.getUsername();

        if (username == null) {
            return "redirect:/user/login";
        }

        model.addAttribute("username", username);
        return "main";
    }
}
