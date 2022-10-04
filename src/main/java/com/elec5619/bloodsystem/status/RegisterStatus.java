package com.elec5619.bloodsystem.status;

/**
 * The enum Register status.
 */
public enum RegisterStatus {
    /**
     * Email exists register status.
     */
    EMAIL_EXISTS("email_exists"),
    /**
     * Empty error register status.
     */
    EMPTY_ERROR("empty_error"),
    /**
     * Password not same register status.
     */
    PASSWORD_NOT_SAME("password_not_same"),
    /**
     * Password not valid register status.
     */
    PASSWORD_NOT_VALID("password_not_valid"),
    /**
     * Success register register status.
     */
    SUCCESS_REGISTER("success_register");


    private final String textRepresentation;

    RegisterStatus(String textRepresentation) {
        this.textRepresentation = textRepresentation;
    }

    @Override public String toString() {
        return textRepresentation;
    }


}
