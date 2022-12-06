package com.flab.common;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    EMAIL_ALREADY_EXIST("존재하는 이메일입니다."),
    EMAIL_NOT_EXIST("존재하지 않는 이메일입니다."),
    PASSWORD_NOT_MATCH("패스워드가 일치하지 않습니다.");


    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
