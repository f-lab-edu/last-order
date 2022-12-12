package com.flab.user.controller.advice;

import com.flab.user.controller.UserController;
import com.flab.user.exception.EmailAlreadyExistException;
import com.flab.user.exception.EmailNotExistException;
import com.flab.user.exception.PasswordNotMatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.flab.common.ErrorMessage.*;

@RestControllerAdvice(assignableTypes = {UserController.class})
public class UserControllerAdvice {

    @ExceptionHandler(EmailAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String emailAlreadyExistExceptionHandler(){
        return EMAIL_ALREADY_EXIST.getMessage();
    }

    @ExceptionHandler(EmailNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String emailNotExistExceptionHandler(){
        return EMAIL_NOT_EXIST.getMessage();
    }

    @ExceptionHandler(PasswordNotMatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String passwordNotMatchExceptionHandler(){
        return PASSWORD_NOT_MATCH.getMessage();
    }
}
