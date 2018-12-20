package com.infinity.service;

import com.infinity.pojo.User;
import com.infinity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

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

    public Page<User> getUsersByNameLike(String username, Pageable pageable) {
        return userRepository.findByUsernameLike("%" + username + "%", pageable);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
