package com.learnist.exception;

public class UserIdDoesntExistException extends Exception{
    public UserIdDoesntExistException(final Long id) {
        super("User with the id: " + id + " doesn't exist");
    }
}
