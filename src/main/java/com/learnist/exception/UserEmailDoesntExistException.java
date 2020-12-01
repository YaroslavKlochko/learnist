package com.learnist.exception;

public class UserEmailDoesntExistException extends Exception {
    public UserEmailDoesntExistException(final String email) {
        super("User with the email: " + email + " doesn't exist");
    }
}
