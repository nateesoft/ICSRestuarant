package com.ics.pos.restaurant.icsrestaurant.service;

import com.ics.pos.restaurant.icsrestaurant.dto.LoginRequestDto;
import com.ics.pos.restaurant.icsrestaurant.dto.LoginResponseDto;
import com.ics.pos.restaurant.icsrestaurant.model.PosuserBean;
import com.ics.pos.restaurant.icsrestaurant.repository.PosuserRepository;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nateelive
 */
public class LoginService {
    private static final Logger logger = Logger.getLogger(LoginService.class.getName());
    private final PosuserRepository repository;

    public LoginService() {
        this.repository = new PosuserRepository();
    }

    public LoginResponseDto validateLogin(LoginRequestDto dto) {
        PosuserBean bean = new PosuserBean();
        bean.setUsername(dto.getUsername());
        bean.setPassword(dto.getPassword());

        PosuserBean resultBean = repository.findByUsernameAndPassword(bean);
        if (resultBean == null) {
            logger.log(Level.WARNING, "Login failed - user not found: {0}", dto.getUsername());
            return null;
        }
        
        LoginResponseDto response = new LoginResponseDto();
        response.setUsername(resultBean.getUsername());
        response.setActive(resultBean.getOnact());
        return response;
    }
}
