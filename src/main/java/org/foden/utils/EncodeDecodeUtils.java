package org.foden.utils;

import java.util.Base64;

public final class EncodeDecodeUtils {

    private EncodeDecodeUtils(){}

    /**
     * Encode to base 64 string.
     *
     * @param message the message
     * @return the string
     */
    public static String encodeToBase64(String message){
        byte[] bytes = message.getBytes();
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * Decode from base 64 string.
     *
     * @param encodeMsg the encode msg
     * @return the string
     */
    public static String decodeFromBase64(String encodeMsg){
        byte[] decodedBytes = Base64.getDecoder().decode(encodeMsg);
        return new String(decodedBytes);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println(EncodeDecodeUtils.encodeToBase64("testingminibytes"));
        System.out.println(EncodeDecodeUtils.decodeFromBase64("dGVzdGluZ21pbmlieXRlcw=="));
    }
}
