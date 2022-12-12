package com.flab.user.exception;

import static com.flab.common.ErrorMessage.*;

public class PasswordNotMatchException extends RuntimeException{
    public PasswordNotMatchException() {
        super(PASSWORD_NOT_MATCH.getMessage());
    }
}
