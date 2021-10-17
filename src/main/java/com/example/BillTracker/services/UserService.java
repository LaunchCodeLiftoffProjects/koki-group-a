package com.example.BillTracker.services;

import com.example.BillTracker.data.UserRepository;
import com.example.BillTracker.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        Optional<User> user = userRepository.findById(userId);
        return user.get();
    }
}
