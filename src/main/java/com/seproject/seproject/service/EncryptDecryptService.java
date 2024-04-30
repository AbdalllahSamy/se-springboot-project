package com.seproject.seproject.service;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class EncryptDecryptService {

    public static Map<String, Object> map = new HashMap<>();

    public void createKeys() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(4096);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
            map.put("publicKey", publicKey);
            map.put("privateKey", privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String encryptMessage(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
            PublicKey publicKey = (PublicKey) map.get("publicKey");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encrypt = cipher.doFinal(plainText.getBytes());
            return new String(Base64.getEncoder().encodeToString(encrypt));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String decryptMessage(String encryptedMessage) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
            PrivateKey privateKey = (PrivateKey) map.get("privateKey");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decrypt = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
            return new String(decrypt);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

}
