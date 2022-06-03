package com.api.products.services.impl;

import com.api.products.Entity.User;
import com.api.products.Models.ExceptionAuth;
import com.api.products.dao.UserRepository;
import com.api.products.services.api.UserService;
import com.api.products.utils.authUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplBasic implements UserService {
    @Autowired
    UserRepository repoUser;

    @Autowired
    BCryptPasswordEncoder encrypter;
    
    @Override
    public void authenticate(String Token) throws ExceptionAuth {
        String TokenHeader = Token.replaceAll("Basic ", "");
        String TokenCredintield = authUtils.ConveteToBase64(authUtils.LOGNAME, authUtils.PASSWORD);
        if(!TokenHeader.equals(TokenCredintield))
            throw new ExceptionAuth("Unothorized Token ");
    }

    @Override
    public void authenticate(String Username, String Password) throws ExceptionAuth {
        User user = repoUser.findByUsername(Username);
        if(user == null)
            throw new ExceptionAuth("Unothorized Token ");
        if (!encrypter.matches(Password, user.getPassword()))
             throw new ExceptionAuth("Unothorized Token ");
    }
    
}
