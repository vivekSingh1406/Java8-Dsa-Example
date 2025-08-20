package com.bezkoder.spring.thymeleaf.util;

public final class WordCountValidator {
    public static boolean isBetweenWords(String text, int min, int max) {
        if (text == null) return false;
        int words = (int) java.util.Arrays.stream(text.trim().split("\\s+")).filter(s -> !s.isBlank()).count();
        return words >= min && words <= max;
    }
}
