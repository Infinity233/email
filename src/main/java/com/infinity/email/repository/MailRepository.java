package com.infinity.email.repository;

import org.springframework.data.domain.Page;
import com.infinity.email.pojo.Mail;
import com.infinity.email.pojo.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MailRepository extends JpaRepository<Mail, Long> {

    Page<Mail> getMailBySender(User user, Pageable pageable);

    Page<Mail> getMailByReceiversContains(User receivers, Pageable pageable);
}
