package com.elec5619.bloodsystem.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Password validation.
 */
public class PasswordValidation {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);


    /**
     * Is valid boolean.
     *
     * @param password the password
     * @return the boolean
     */
    public static boolean isValid(final String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
