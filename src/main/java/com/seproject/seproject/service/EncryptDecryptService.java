package com.seproject.seproject.service;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class EncryptDecryptService {

    private Map<String, Object> map = new HashMap<>();

    public String encryptMessage(String plainText) {
        try {
            // Generate new keys if not already present
            if (map.get("publicKey") == null || map.get("privateKey") == null) {
                createKeys();
            }

            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
            PublicKey publicKey = (PublicKey) map.get("publicKey");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            // Break the plaintext into chunks and encrypt each chunk separately
            int chunkSize = 245; // Adjust this based on key size
            byte[] plainBytes = plainText.getBytes();
            StringBuilder encryptedText = new StringBuilder();

            for (int i = 0; i < plainBytes.length; i += chunkSize) {
                byte[] chunk = new byte[Math.min(chunkSize, plainBytes.length - i)];
                System.arraycopy(plainBytes, i, chunk, 0, chunk.length);
                byte[] encrypt = cipher.doFinal(chunk);
                encryptedText.append(Base64.getEncoder().encodeToString(encrypt));
            }

            return encryptedText.toString();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

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
}
