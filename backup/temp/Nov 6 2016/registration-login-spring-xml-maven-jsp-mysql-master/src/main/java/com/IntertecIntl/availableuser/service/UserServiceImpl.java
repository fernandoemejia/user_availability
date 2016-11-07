package com.IntertecIntl.availableuser.service;

import com.IntertecIntl.availableuser.model.User;
import com.IntertecIntl.availableuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
   
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
