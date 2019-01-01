package com.infinity.email.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/")
    public String chu() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("login");
        return "/login";
    }

    @RequestMapping("/mainPage")
    public String main() {
        return "/main";
    }
}
