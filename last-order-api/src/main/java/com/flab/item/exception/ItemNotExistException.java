package com.flab.item.exception;

import static com.flab.common.ErrorMessage.*;

public class ItemNotExistException extends RuntimeException{
    public ItemNotExistException(){
        super(ITEM_NOT_EXIST.getMessage());
    }
}
