package org.qualitech.foodnet.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Aram Kirakosyan
 */
public class HashUtil {

    public static String hash(String data) throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(data.getBytes());
        byte[] messageDigestSHA = messageDigest.digest();
        StringBuffer message = new StringBuffer();
        for (byte bytes : messageDigestSHA) {
            message.append(String.format("%02x", bytes & 0xff));
        }
        return message.toString();
    }

    public static String generateRandomString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }
}
