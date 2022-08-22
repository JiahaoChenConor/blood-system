package com.elec5619.bloodsystem.security;


public enum ApplicationUserPermission {
    MESSAGE_READ("message:read"),
    MESSAGE_WRITE("message:write"),
    MESSAGE_DELETE("message:delete");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
