package com.example.vehicle.SecurityConfig;

public enum ApplicationUserPermission {
    MANAGE_VEHICLE("admin:manage");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

}
