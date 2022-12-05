package com.example.vehicle.SecurityConfig;

import java.util.Set;

import com.google.common.collect.Sets;
import static com.example.vehicle.SecurityConfig.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet(MANAGE_VEHICLE)),
    VISITOR(Sets.newHashSet());

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
}
