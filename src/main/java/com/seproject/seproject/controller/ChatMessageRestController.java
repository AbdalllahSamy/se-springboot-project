package com.seproject.seproject.controller;

import com.seproject.seproject.model.*;
import com.seproject.seproject.service.ChatMessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ChatMessageRestController {
    private ChatMessageService chatMessageService;
    
    public ChatMessageRestController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @GetMapping("/chat/{person1}/{person2}")
    public List<ChatMessage> getAllMessages(@PathVariable("person1") int person1,@PathVariable("person2") int person2) {
        return chatMessageService.getAllMessages(person1,person2);
    }
    @PostMapping("/chat")
    public ChatMessage sendMessage(@RequestBody ChatMessage message) {
        ChatMessage theMessage = chatMessageService.addMessage(message);
        return theMessage;
    }
    
}
