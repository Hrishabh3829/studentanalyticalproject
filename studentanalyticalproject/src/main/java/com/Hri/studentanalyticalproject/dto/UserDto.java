package com.Hri.studentanalyticalproject.dto;

import com.Hri.studentanalyticalproject.model.User;

public class UserDto {

    private User user;
    private String msg;

    public UserDto() { }

    public UserDto(User user, String msg) {
        this.user = user;
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
