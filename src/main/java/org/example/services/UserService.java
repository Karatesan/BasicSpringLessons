package org.example.services;

import jakarta.transaction.Transactional;
import org.example.model.MyUser;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<MyUser> findAllUsers() {
        return userRepository.findAll();
    }

    public MyUser findUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Transactional
    public MyUser saveUser(MyUser user) {
        return userRepository.save(user);
    }
}