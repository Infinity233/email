package com.infinity.repository;

import com.infinity.pojo.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MailRepository extends JpaRepository<Mail, Long> {


}
