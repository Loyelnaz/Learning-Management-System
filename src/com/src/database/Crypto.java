package com.src.database;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Crypto {
	
	private static final String ALGORITHM = "AES";
    private static final String KEY = "1Hbfh667adfDEJ78";
    
    // Function to encrypt password
    public static String encrypt(String value) throws Exception {
        
    	Key key = generateKey();
        Cipher cipher = Cipher.getInstance(Crypto.ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte [] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
        String encryptedValue64 = new BASE64Encoder().encode(encryptedByteValue);
        
        return encryptedValue64;       
    }
    
    // Function to decrypt password
    public static String decrypt(String value) throws Exception {
        
    	Key key = generateKey();
        Cipher cipher = Cipher.getInstance(Crypto.ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte [] decryptedValue64 = new BASE64Decoder().decodeBuffer(value);
        byte [] decryptedByteValue = cipher.doFinal(decryptedValue64);
        String decryptedValue = new String(decryptedByteValue,"utf-8");
        
        return decryptedValue;        
    }
    
    // Function to generate secret key
    private static Key generateKey() throws Exception {
    	
    	Key key = new SecretKeySpec(Crypto.KEY.getBytes(),Crypto.ALGORITHM);
    	return key;
    
    }
}
