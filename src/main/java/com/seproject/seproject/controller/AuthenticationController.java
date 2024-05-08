package com.seproject.seproject.controller;

import com.seproject.seproject.model.ApiResponse;
import com.seproject.seproject.model.User;
import com.seproject.seproject.service.AuthenticationService;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // Your other methods...

    // Validate user input
    private boolean isValidUser(User user) {
        return user != null &&
                !StringUtils.isEmpty(user.getUsername()) &&
                !StringUtils.isEmpty(user.getPassword());
    }

    @PostMapping("/register")
    public ApiResponse register(@Valid @RequestBody User request) {
        if (!isValidUser(request)) {
            return ApiResponse.createResponse("Error in request", null, false);
        }

        // Attempt registration
        ApiResponse response = authenticationService.register(request);

        // Handle registration result
        // if (response) {
            return response;

        // } else {
            // If registration fails, set success to false
            // response.setSuccess(false);
            // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@Valid @RequestBody User request) {
        // Validate user input
        if (!isValidUser(request)) {
            return ResponseEntity.badRequest().body(ApiResponse.createResponse("Invalid user data", null,false));
        }

        // Attempt login
        ApiResponse response = authenticationService.authentication(request);

        // Handle login result
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

}
