package com.flab.favorite.controller.advice;

import com.flab.favorite.controller.FavoriteController;
import com.flab.favorite.exception.AlreadyFavoriteException;
import com.flab.favorite.exception.FavoriteNotExistException;
import com.flab.store.exception.StoreNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static com.flab.common.ErrorMessage.*;

@RestControllerAdvice(assignableTypes = {FavoriteController.class})
public class FavoriteControllerAdvice {

    @ExceptionHandler(FavoriteNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String favoriteNotExistExceptionHandler() {
        return FAVORITE_NOT_EXIST.getMessage();
    }

    @ExceptionHandler(StoreNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String storeNotExistExceptionHandler() {
        return STORE_NOT_EXIST.getMessage();
    }

    @ExceptionHandler(AlreadyFavoriteException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String alreadyFavoriteExceptionHandler() {
        return FAVORITE_ALREADY_EXIST.getMessage();
    }
}
