package com.bezkoder.spring.thymeleaf.util;

import java.util.regex.Pattern;

public final class PasswordValidator {
    private static final Pattern P = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{9,}$"
    );
    public static boolean isStrong(String raw) {
        return raw != null && P.matcher(raw).matches();
    }
}