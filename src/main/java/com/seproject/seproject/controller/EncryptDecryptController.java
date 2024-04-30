package com.seproject.seproject.controller;

import com.seproject.seproject.service.EncryptDecryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EncryptDecryptController {

    @Autowired
    EncryptDecryptService encryptDecryptService;

    @GetMapping("/createKeys")
    public void createPrivatePublicKey(){
        encryptDecryptService.createKeys();
    }

    @PostMapping("/encrypt")
    public String encryptMessage(@RequestBody String plainString){
        return encryptDecryptService.encryptMessage(plainString);
    }

    @PostMapping("/decrypt")
    public String decryptMessage(@RequestBody String encryptString){
        return encryptDecryptService.decryptMessage(encryptString);
    }

}
