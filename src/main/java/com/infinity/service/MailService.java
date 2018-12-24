package com.infinity.service;

import com.infinity.pojo.Mail;
import com.infinity.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class MailService {

    @Autowired
    MailRepository mailRepository;

    @Transactional
    public Mail sendMail(Mail mail) {

        return mailRepository.save(mail);
    }
}
