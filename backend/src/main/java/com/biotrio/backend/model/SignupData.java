package com.biotrio.backend.model;

/**
 * Responsible for creating Sign up objects
 *
 * This class contains methods related to setting and getting different parameters of a Sign up form.
 */
public class SignupData {

    private String email;
    private String password;
    private String confirmPassword;
    private String phoneNumber;
    private String name;

    public SignupData(String email, String password, String confirmPassword, String phoneNumber, String name) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
