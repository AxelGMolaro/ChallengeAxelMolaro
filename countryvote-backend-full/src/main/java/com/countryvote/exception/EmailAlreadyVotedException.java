package com.countryvote.exception;

public class EmailAlreadyVotedException extends RuntimeException {
    public EmailAlreadyVotedException() {
        super("Email already voted");
    }
}
