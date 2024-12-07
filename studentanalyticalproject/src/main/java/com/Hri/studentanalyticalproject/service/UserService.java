package com.Hri.studentanalyticalproject.service;

import com.Hri.studentanalyticalproject.model.User;

public interface UserService {

    String add(User user);
    String login(String email, String password);

    User getByEmail(String email);
}
