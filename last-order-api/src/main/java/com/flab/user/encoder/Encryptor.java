package com.flab.user.encoder;

public interface Encryptor {
    String encoder(String password);

    boolean checkPassword(String password, String hashed);
}
