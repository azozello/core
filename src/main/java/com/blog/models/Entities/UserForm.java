package com.blog.models.Entities;


import javax.validation.constraints.NotNull;

public class UserForm {

    @NotNull
    private String login;

    @NotNull
    private String passwordOne;

    @NotNull
    private String passwordTwo;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswordOne(String passwordOne) {
        this.passwordOne = passwordOne;
    }

    public void setPasswordTwo(String passwordTwo) {
        this.passwordTwo = passwordTwo;
    }

    public String getLogin() {

        return login;
    }

    public String getPasswordOne() {
        return passwordOne;
    }

    public String getPasswordTwo() {
        return passwordTwo;
    }
}
