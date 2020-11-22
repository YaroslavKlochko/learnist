package com.learnist.exception;

public class UserDoesntExistException extends Exception {
    public UserDoesntExistException(final String user) {
        super("User with the email: " + user + " doesn't exist");
    }
}
