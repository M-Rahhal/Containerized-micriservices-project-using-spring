package com.Authentication.AuthenticationService.Service;

import com.Authentication.AuthenticationService.dao.UserDao;
import com.Authentication.AuthenticationService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class AuthenticationService {

    @Autowired
    private UserDao dao ;


    public AuthenticationService(){

    }
    public boolean isUser(String username , String password){

        try {
            User user = dao.getUserByUsername(username);
            if (password.equals(user.getPassword()))
                return true;
            return false;
        }
        catch (EmptyResultDataAccessException e){
            return false;
        }
    }

}
