package com.flab.common;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    EMAIL_ALREADY_EXIST("존재하는 이메일입니다."),
    EMAIL_NOT_EXIST("존재하지 않는 이메일입니다."),
    PASSWORD_NOT_MATCH("패스워드가 일치하지 않습니다."),
    ITEM_NOT_EXIST("존재하지 않는 상품입니다."),
    FAVORITE_NOT_EXIST("존재하지 않는 즐겨찾기입니다."),
    FAVORITE_ALREADY_EXIST("이미 즐겨찾기를 하셨습니다."),
    STORE_NOT_EXIST("존재하지 않는 가게입니다.");


    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
