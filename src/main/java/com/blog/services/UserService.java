package com.blog.services;

import com.blog.models.Entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUserById(Integer id);

    Iterable<User> getAllUsers();

    void insertUsers(User user);
}
