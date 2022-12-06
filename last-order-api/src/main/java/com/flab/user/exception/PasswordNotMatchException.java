package com.flab.user.exception;

import com.flab.common.ErrorMessage;

public class PasswordNotMatchException extends RuntimeException{
    public PasswordNotMatchException(ErrorMessage err) {
        super(err.getMessage());
    }
}
