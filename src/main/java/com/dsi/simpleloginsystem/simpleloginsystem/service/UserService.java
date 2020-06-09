package com.dsi.simpleloginsystem.simpleloginsystem.service;

import com.dsi.simpleloginsystem.simpleloginsystem.model.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean loginUser(CurrentUser currentUser);
}
