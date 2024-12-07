package com.Hri.studentanalyticalproject.service;

import com.Hri.studentanalyticalproject.model.User;
import com.Hri.studentanalyticalproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public String add(User user) {
        if (userRepo.findById(user.getId()).isPresent() || userRepo.findByEmail(user.getEmail()) != null) {
            return "User already exists!";
        }

        user.setPassword(user.getPassword());
        user.setVerified(false);

        userRepo.save(user);
        return "User added Successfully!";
    }

    @Override
    public String login(String email, String password) {
        try {
            User user = userRepo.findByEmail(email);

            if (!user.isVerified()) {
                return "Email not verified!";
            }

			if (user.getPassword().equals(password)) {
                return "Login Successful!";
            }

            return "Invalid Password!";
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return "Invalid ID!";
        }
    }

    @Override
    public User getByEmail(String email) {
        return userRepo.findByEmail(email);
    }

}
