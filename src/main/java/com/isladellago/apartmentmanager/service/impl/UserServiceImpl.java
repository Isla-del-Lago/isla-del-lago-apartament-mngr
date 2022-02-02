package com.isladellago.apartmentmanager.service.impl;

import com.isladellago.apartmentmanager.domain.model.User;
import com.isladellago.apartmentmanager.domain.model.UserRepository;
import com.isladellago.apartmentmanager.exception.UserNotFoundException;
import com.isladellago.apartmentmanager.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        log.info("[Get user by email] Method start, email: {}", email);
        return userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email));
    }
}
