package com.infinity.email.service;

import com.infinity.email.pojo.User;
import com.infinity.email.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Page<User> getUsersByNameLike(String username, Pageable pageable) {
        return userRepository.findByUsernameLike("%" + username + "%", pageable);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
