package com.gdg.backendse.util;

public class NicknameGenerator {
    public static String generateRandomNickname() {
        String[] adjectives = {"Happy", "Bright", "Calm", "Cool"};
        String[] nouns = {"Panda", "Lion", "Tiger", "Fox"};
        return adjectives[(int)(Math.random() * adjectives.length)]
                + nouns[(int)(Math.random() * nouns.length)];
    }
}
