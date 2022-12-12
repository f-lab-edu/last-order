package com.flab.user.exception;

import com.flab.common.ErrorMessage;

import static com.flab.common.ErrorMessage.*;

public class EmailNotExistException extends RuntimeException {
    public EmailNotExistException() {
        super(EMAIL_NOT_EXIST.getMessage());
    }
}
