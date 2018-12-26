package com.infinity.email.controller;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.infinity.email.pojo.Mail;
import com.infinity.email.pojo.User;
import com.infinity.email.service.MailService;
import com.infinity.email.service.UserService;
import com.infinity.email.vo.Response;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    UserService userService;

    @Autowired
    MailService mailService;

    @GetMapping("/{username}/sended")
    public ResponseEntity<Response> sendedMail(Integer pageIndex, Integer pageSize
            , @PathVariable("username") String username) {

        User user = userService.getUserByUsername(username);
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Preconditions.checkNotNull(user, "发件人信息有误");
        Page<Mail> sendedMails = mailService.getSendedMails(user, pageable);
        List<Mail> mails = sendedMails.getContent();

        return ResponseEntity.ok().body(Response.builder().success(true).message("获取成功").body(mails).build());
    }

    @GetMapping("/{username}/received")
    public ResponseEntity<Response> receivedMail(Integer pageIndex, Integer pageSize
            , @PathVariable("username") String username) {

        User user = userService.getUserByUsername(username);
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Preconditions.checkNotNull(user, "发件人信息有误");
        Page<Mail> receivedMails = mailService.getReceivedMails(user, pageable);
        List<Mail> mails = receivedMails.getContent();


        return ResponseEntity.ok().body(Response.builder().success(true).message("获取成功").body(mails).build());

    }


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
