package com.seproject.seproject.service;

import com.seproject.seproject.dao.ChatMessageDAO;
import com.seproject.seproject.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChatMessageService {
    private ChatMessageDAO chatMessageDAO;
    @Autowired
    public ChatMessageService(ChatMessageDAO chatMessageDAO) {
        this.chatMessageDAO = chatMessageDAO;
    }
    public List<ChatMessage>getAllMessages(int person1,int person2){
        return chatMessageDAO.getAllMessages(person1,person2);
    }
    @Transactional
    public ChatMessage addMessage(ChatMessage chatMessage){
        ChatMessage theChatMessage=chatMessageDAO.addMessage(chatMessage);
        return theChatMessage;
    }
}
