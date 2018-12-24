package com.infinity.controller;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.infinity.pojo.Mail;
import com.infinity.pojo.User;
import com.infinity.service.MailService;
import com.infinity.service.UserService;
import com.infinity.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    UserService userService;

    @Autowired
    MailService mailService;

    @PostMapping("/{username}")
    public ResponseEntity<Response> sendMail(@PathVariable("username") String username, @RequestBody Mail mail) {

        if (!Strings.isNullOrEmpty(username)) {
            mail.setSender(userService.getUserByUsername(username));
        }

        Preconditions.checkNotNull(mail.getSender(), "发件人有误");
        try {
            mailService.sendMail(mail);
        } catch (Exception e) {
            return ResponseEntity.ok().body(Response.builder().success(false).body(e.getMessage()).build());
        }

        return ResponseEntity.ok().body(Response.builder().success(true).message("发送成功").build());
    }
}
