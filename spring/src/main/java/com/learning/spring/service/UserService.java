package com.learning.spring.service;

import com.learning.spring.model.User;

import java.util.List;

public interface UserService {

    /*C: Create operation*/
    User saveUser(User user);

    /*R: Read operation  */
    List<User> fetchUserList();

    /*U: Update operation*/
    User updateUser(User user, Long userId);

    /*D: Delete operation*/
    void deleteUserById(Long userId);
}
