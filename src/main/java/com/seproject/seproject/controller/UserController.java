package com.seproject.seproject.controller;

import com.seproject.seproject.model.User;
import com.seproject.seproject.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/my-data")
    public User getUserData(@RequestHeader("Authorization") String authorizationHeader){
        String token = authorizationHeader.substring("Bearer ".length());
        return this.userService.getMyData(token);
    }

}
