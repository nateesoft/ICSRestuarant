package com.ics.pos.restaurant.icsrestaurant.controller;

import com.ics.pos.restaurant.icsrestaurant.dto.LoginRequestDto;
import com.ics.pos.restaurant.icsrestaurant.dto.LoginResponseDto;
import com.ics.pos.restaurant.icsrestaurant.service.LoginService;

/**
 *
 * @author nateelive
 */
public class LoginController {
    private final LoginService service;
    
    public LoginController() {
        service = new LoginService();
    }
    
    public LoginResponseDto validateLogin(LoginRequestDto dto) {
        return service.validateLogin(dto);
    }
    
}
