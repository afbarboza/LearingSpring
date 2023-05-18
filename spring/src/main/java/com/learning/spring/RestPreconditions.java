package com.learning.spring;

import com.learning.spring.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RestPreconditions {
    public static void checkUserNotNull(User user) {
        if (null == user) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Invalid user properties",
                    new NullPointerException("Null user passed as valid body request"));
        }
    }

    public static void checkUserProperties(User user) {
        String name = user.getName();
        String roles = user.getRoles();
        String password = user.getPassword();

        if (null == name || name.isBlank()          ||
            null == password || password.isBlank()  ||
            null == roles || roles.isBlank()) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Invalid user properties",
                    null);
        }
    }
}
