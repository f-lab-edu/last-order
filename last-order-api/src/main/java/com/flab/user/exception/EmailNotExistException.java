package com.flab.user.exception;

import com.flab.common.ErrorMessage;

public class EmailNotExistException extends RuntimeException {
    public EmailNotExistException(ErrorMessage err) {
        super(err.getMessage());
    }
}
