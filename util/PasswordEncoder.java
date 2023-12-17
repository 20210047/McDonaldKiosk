package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordEncoder {

    public String getSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[20];

        secureRandom.nextBytes(salt);
        StringBuffer sb = new StringBuffer();
        for(byte b : salt) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String getPassword(String password, String salt) {
        String encryptPassword = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update((password+salt).getBytes());
            byte[] passwordSalt = md.digest();

            StringBuffer sb = new StringBuffer();
            for(byte b : passwordSalt) {
                sb.append(String.format("%02x", b));
            }
            encryptPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptPassword;
    }
}
