package com.infinity.email.controller;

import com.infinity.email.pojo.User;
import com.infinity.email.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String list(Integer pageIndex, Integer pageSize, String username, Model model) {

        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<User> page = userService.getUsersByNameLike(username, pageable);
        List<User> users = page.getContent();

        model.addAttribute("page", page);
        model.addAttribute("userList", users);

//        return new ModelAndView("users/list", "userModel", model);
        return users.toString();
    }

    @PostMapping("/all")
    public String all() {

        return userService.getAll().toString();
    }
}
