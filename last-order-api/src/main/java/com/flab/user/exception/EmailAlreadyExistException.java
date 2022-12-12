package com.flab.user.exception;

import com.flab.common.ErrorMessage;

import static com.flab.common.ErrorMessage.*;

public class EmailAlreadyExistException extends RuntimeException{
    public EmailAlreadyExistException() {
        super(EMAIL_ALREADY_EXIST.getMessage());
    }
}
