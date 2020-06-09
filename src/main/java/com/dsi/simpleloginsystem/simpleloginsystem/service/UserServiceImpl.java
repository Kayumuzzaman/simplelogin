package com.dsi.simpleloginsystem.simpleloginsystem.service;

import com.dsi.simpleloginsystem.simpleloginsystem.model.CurrentUser;
import com.dsi.simpleloginsystem.simpleloginsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean loginUser(CurrentUser currentUser) {
        List<CurrentUser> currentUserArrayList = userRepository.findAll();
        for (CurrentUser currentUserCheck : currentUserArrayList) {
            if (currentUserCheck.getUserEmail().equalsIgnoreCase(currentUser.getUserEmail()) && currentUserCheck.getUserPassword().equals(currentUser.getUserPassword())) {
                return true;
            }
        }
        return false;
    }
}
