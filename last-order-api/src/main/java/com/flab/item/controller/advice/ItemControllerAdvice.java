package com.flab.item.controller.advice;

import com.flab.common.ErrorMessage;
import com.flab.item.controller.ItemController;
import com.flab.item.exception.ItemNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RequiredArgsConstructor
@RestControllerAdvice(assignableTypes = {ItemController.class})
public class ItemControllerAdvice {

    @ExceptionHandler(ItemNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String boardNotExistsExceptionHandler() {
        return ErrorMessage.ITEM_NOT_EXIST.getMessage();
    }
}
