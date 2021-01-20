package com.geeksHub.dev.security;

public enum ApplicationUserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    public final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

}
