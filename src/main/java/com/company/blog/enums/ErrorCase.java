package com.company.blog.enums;

public enum ErrorCase {
    NOT_FOUND("Such Comment not found`"),
    USER_NOT_FOUND("User not found"),
    SUCCESS_LOGIN("User successfully sign in"),
    SUCCESSFULLY_REGISTER("User successfully registered"),
    EMAIL_ALREADY_TAKEN("Such email already registered"),
    USERNAME_ALREADY_TAKEN("Such username already registered"),
    USER_UNCONFIRMED("User unconfirmed!!");
    private String message;

    ErrorCase(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
