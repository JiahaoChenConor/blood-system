package com.elec5619.bloodsystem.status;

public enum RegisterStatus {
    EMAIL_EXISTS("email_exists"),
    EMPTY_ERROR("empty_error"),
    PASSWORD_NOT_SAME("password_not_same"),
    PASSWORD_NOT_VALID("password_not_valid"),
    SUCCESS_REGISTER("success_register");


    private final String textRepresentation;

    RegisterStatus(String textRepresentation) {
        this.textRepresentation = textRepresentation;
    }

    @Override public String toString() {
        return textRepresentation;
    }


}
