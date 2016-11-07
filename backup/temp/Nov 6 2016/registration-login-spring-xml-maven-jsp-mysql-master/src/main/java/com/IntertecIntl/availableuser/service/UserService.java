package com.IntertecIntl.availableuser.service;

import com.IntertecIntl.availableuser.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
