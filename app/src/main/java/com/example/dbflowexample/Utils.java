package com.example.dbflowexample;

import androidx.annotation.UiThread;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

    public static String hash(String str, String algorithm) {
        try {
            String _password = new String(MessageDigest
                    .getInstance(algorithm)
                    .digest(str.getBytes("UTF-8")));
            return _password;
        } catch(NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return null;
        }
    }

    public static String sha256(String str) {
        return Utils.hash(str, "SHA-256");
    }
}
