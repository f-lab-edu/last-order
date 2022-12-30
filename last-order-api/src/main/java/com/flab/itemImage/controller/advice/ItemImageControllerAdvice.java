package com.flab.itemImage.controller.advice;

import com.flab.itemImage.controller.ItemImageController;
import com.flab.itemImage.exception.ImageNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.flab.common.ErrorMessage.ITEM_IMAGE_NOT_EXIST;

@RestControllerAdvice(assignableTypes = {ItemImageController.class})
public class ItemImageControllerAdvice {

    @ExceptionHandler(ImageNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String itemNotExistsExceptionHandler() {
        return ITEM_IMAGE_NOT_EXIST.getMessage();
    }
}
