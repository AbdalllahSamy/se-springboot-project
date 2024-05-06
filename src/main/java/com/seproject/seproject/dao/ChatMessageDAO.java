package com.seproject.seproject.dao;

import com.seproject.seproject.model.*;
import com.seproject.seproject.service.EncryptDecryptService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;

@Repository
public class ChatMessageDAO {
    //fields
    EntityManager entityManager;
    EncryptDecryptService encryptDecryptService;



    //constructors
    @Autowired
    public ChatMessageDAO(EntityManager entityManager, EncryptDecryptService encryptDecryptService) {
        this.entityManager = entityManager;
        this.encryptDecryptService = encryptDecryptService;
    }
        
    //functions
    public List<ChatMessage> getAllMessages(int person1,int person2){

        TypedQuery<ChatMessage> theQuery = entityManager.createQuery("SELECT c FROM ChatMessage c WHERE (c.senderId = :sender1 AND c.receiverId = :receiver1) OR (c.senderId = :sender2 AND c.receiverId = :receiver2)", ChatMessage.class);
        theQuery.setParameter("sender1", person1);
        theQuery.setParameter("receiver1", person2);
        theQuery.setParameter("sender2", person2);
        theQuery.setParameter("receiver2", person1);

        List<ChatMessage> chat = theQuery.getResultList();
        for (ChatMessage message : chat) {
            encryptDecryptService.createKeys();
            message.setContent(encryptDecryptService.encryptMessage(message.getContent()));
            message.setContent(encryptDecryptService.decryptMessage(message.getContent()));
        }
        return getSortedMessages(chat);
    }

    public List<ChatMessage> getSortedMessages(List<ChatMessage> messages) {
        // Sort messages by timestamp using Comparator
        //messages.sort(Comparator.comparing(ChatMessage::getTimestamp).reversed());
        messages.sort(Comparator.comparing(ChatMessage::getTimestamp));
        return messages;
    }

    public ChatMessage addMessage(ChatMessage message){
        encryptDecryptService.createKeys();
        String hashed = encryptDecryptService.encryptMessage(message.getContent());
        message.setId(0);
        message.setTimestamp(convertToCairoLocalDateTime(System.currentTimeMillis()));
        message.setContent(encryptDecryptService.decryptMessage(hashed));
        ChatMessage theChatMessage = entityManager.merge(message);
        return theChatMessage;
    }

    private LocalDateTime convertToCairoLocalDateTime(long millis) {
        ZoneId cairoZoneId = ZoneId.of("Africa/Cairo");
        return LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(millis), cairoZoneId);
    }
}
