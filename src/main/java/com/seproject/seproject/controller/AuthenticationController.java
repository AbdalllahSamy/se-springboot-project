package com.seproject.seproject.controller;

import com.seproject.seproject.model.ApiResponse;
import com.seproject.seproject.model.User;
import com.seproject.seproject.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

//    @PostMapping("/register")
//    public ResponseEntity<ApiResponse> register(
//            @RequestBody User request
//            ) {
//        return ResponseEntity.ok(authenticationService.register(request));
//    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(
            @RequestBody User request
    ) {
        return ResponseEntity.ok(authenticationService.     authentication(request));
    }

}
