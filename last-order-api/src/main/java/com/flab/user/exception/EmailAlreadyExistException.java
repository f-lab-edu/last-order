package com.flab.user.exception;

import com.flab.common.ErrorMessage;

public class EmailAlreadyExistException extends RuntimeException{
    public EmailAlreadyExistException(ErrorMessage err) {
        super(err.getMessage());
    }
}
