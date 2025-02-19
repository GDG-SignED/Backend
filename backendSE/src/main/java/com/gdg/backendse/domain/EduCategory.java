package com.gdg.backendse.domain;

public enum EduCategory {
    CONSONANT("자음"),
    VOWEL("모음"),
    BASIC_WORD("기초단어");

    private final String name;

    EduCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

