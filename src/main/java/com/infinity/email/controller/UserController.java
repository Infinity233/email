package com.infinity.email.controller;

import com.google.common.collect.Lists;
import com.infinity.email.pojo.Authority;
import com.infinity.email.pojo.User;
import com.infinity.email.service.AuthorityService;
import com.infinity.email.service.UserService;
import com.infinity.email.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

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

    @PostMapping
    public ResponseEntity<Response> register(User user, Long authorityId) {

        User t = userService.getUserByUsername(user.getUsername());

        if (t != null) {
            return ResponseEntity.ok().body(Response.builder().success(false).message("用户已存在").build());
        }

        Authority authority = authorityService.getAuthorityById(authorityId);
        user.setAuthorities(Lists.newArrayList(authority));
        User res = userService.saveUser(user);
        return ResponseEntity.ok().body(Response.builder().success(true).message("注册成功").body(res).build());
    }
}
