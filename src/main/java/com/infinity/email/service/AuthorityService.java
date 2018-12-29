package com.infinity.email.service;

import com.infinity.email.pojo.Authority;
import com.infinity.email.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

    @Autowired
    AuthorityRepository authorityRepository;

    public Authority getAuthorityById(Long id){

        return authorityRepository.getOne(id);
    }
}
