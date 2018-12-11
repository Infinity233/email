package com.infinity.service;

import com.infinity.pojo.User;

public interface UserService {

    User saveUser(User user);

    User registerUser(User user);

    void removeUser(Long id);

    User getUserById(Long id);

}
