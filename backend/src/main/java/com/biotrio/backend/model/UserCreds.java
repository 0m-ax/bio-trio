package com.biotrio.backend.model;

/**
 * Responsible for creating login objects
 *
 * This class contains methods related to setting and getting different parameters of a login form.
 */
public class UserCreds {
    private String username;
    private String password;
    public UserCreds(){

    }
    public UserCreds(String username,String password){
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
