package com.bryanlema.springboot.webapp.springbootwebapp.models.dto;

import com.bryanlema.springboot.webapp.springbootwebapp.models.User;

public class UserDTO {

    private String title;
    private User user;

    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    

}
