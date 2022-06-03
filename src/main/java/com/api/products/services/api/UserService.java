package com.api.products.services.api;

import com.api.products.Models.ExceptionAuth;

public interface UserService {
    
    void authenticate(String Token) throws ExceptionAuth;
    void authenticate(String Username, String Password) throws ExceptionAuth;
}
