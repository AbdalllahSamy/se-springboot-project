package com.seproject.seproject.service;

import com.seproject.seproject.model.Token;
import com.seproject.seproject.model.User;
import com.seproject.seproject.repository.TokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Optional;

@Service
public class UserService {

    private final TokenRepository tokenRepository;

    public UserService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public User getMyData(String token){
        Optional<Token> userToken = tokenRepository.findByToken(token);
        User user = userToken.map(Token::getUser).orElse(null);
        return user;
    }

}
