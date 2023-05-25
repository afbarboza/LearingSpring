package com.learning.spring.service;

import com.learning.spring.model.User;
import com.learning.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Long userId) {
        User userDB = userRepository.findById(userId).get();
        userDB.setName(user.getName());
        userDB.setPassword(user.getPassword());
        userDB.setRoles(user.getRoles());
        return userRepository.save(userDB);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
