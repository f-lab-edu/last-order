package com.flab.user.encoder;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncrypt implements Encryptor{
    @Override
    public String encoder(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean checkPassword(String password, String hashed) {
        return BCrypt.checkpw(password,hashed);
    }
}
