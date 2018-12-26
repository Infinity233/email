package com.infinity.email.service;

import com.google.common.collect.Lists;
import com.infinity.email.pojo.Mail;
import com.infinity.email.pojo.User;
import com.infinity.email.repository.MailRepository;
import com.infinity.email.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


@Service
public class MailService {

    @Autowired
    MailRepository mailRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public Mail sendMail(Mail mail) {

        ListIterator<User> it = mail.getReceivers().listIterator();

        while(it.hasNext()) {

            User user = userRepository.findByUsername(it.next   ().getUsername());
            if(user == null) {

                it.remove();
            }

            it.set(user);
        }
        return mailRepository.save(mail);
    }

    public Page<Mail> getSendedMails(User user, Pageable pageable) {

        return mailRepository.getMailBySender(user, pageable);
    }

    public Page<Mail> getReceivedMails(User user, Pageable pageable) {

        return mailRepository.getMailByReceiversContains(user, pageable);
    }
}
