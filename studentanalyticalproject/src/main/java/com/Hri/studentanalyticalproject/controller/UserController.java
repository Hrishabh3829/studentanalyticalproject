package com.Hri.studentanalyticalproject.controller;

import com.Hri.studentanalyticalproject.dto.UserDto;
import com.Hri.studentanalyticalproject.model.User;
import com.Hri.studentanalyticalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserDto> add(@RequestBody User user) throws NoSuchAlgorithmException {
        String msg = userService.add(user);

        HttpStatus status = msg.equals("User already exists!") ? HttpStatus.CONFLICT : HttpStatus.CREATED;

        if (!status.equals(HttpStatus.CREATED)) {
            user = null;
        }

        return new ResponseEntity<>(new UserDto(user, msg), status);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody User user) {
        String msg = userService.login(user.getEmail(), user.getPassword());

        HttpStatus status = msg.equals("Email not verified!") ? HttpStatus.FORBIDDEN :
                (msg.equals("Login Successful!") ? HttpStatus.OK :
                        (msg.equals("Invalid Password!") ? HttpStatus.UNAUTHORIZED : HttpStatus.NOT_FOUND ));

        if (status.equals(HttpStatus.OK)) {
            user = userService.getByEmail(user.getEmail());
        }

        return new ResponseEntity<>(new UserDto(user, msg), status);
    }

}
