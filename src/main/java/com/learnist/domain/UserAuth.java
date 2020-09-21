package com.learnist.domain;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserAuth extends org.springframework.security.core.userdetails.User {
    private final String username;
    private final String password;

    public UserAuth(final String username,
                    final String password,
                    Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.username = username;
        this.password = password;
    }

    public UserAuth(final String username,
                    final String password,
                    final boolean enabled,
                    final boolean accountNonExpired,
                    final boolean credentialsNonExpired,
                    final boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.username = username;
        this.password = password;
    }
}
