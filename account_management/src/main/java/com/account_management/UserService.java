package com.account_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser() {
        User user = new User();
        user.setId("1");
        user.setName("test");
        user.setAge(10);
        userRepository.save(user);
    }
}
