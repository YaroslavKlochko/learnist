package com.learnist.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum RoleName {
    ROLE_ADMIN, ROLE_USER;

    public static List<String> getRolesWithoutRoleUser() {
        return Stream.of(RoleName.values())
                .map(Enum::name)
                .filter(r -> !r.equals("ROLE_USER"))
                .collect(Collectors.toList());
    }
}
