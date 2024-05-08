package com.seproject.seproject.controller;

import com.seproject.seproject.model.User;
import com.seproject.seproject.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PersistenceContext
    private EntityManager entityManager;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/my-data")
    public User getUserData(@RequestHeader("Authorization") String authorizationHeader){
        String token = authorizationHeader.substring("Bearer ".length());
        return this.userService.getMyData(token);
    }

    @GetMapping("/admin/users")
    public List<User> getUsers(){
        TypedQuery<User> theQuery = entityManager.createQuery("FROM User", User.class);
        List<User> users = theQuery.getResultList();
        return users;
    }

}
