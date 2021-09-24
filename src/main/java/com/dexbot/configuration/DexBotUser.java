package com.dexbot.configuration;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;


public class DexBotUser extends User {

    public DexBotUser(String username, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        // TODO Auto-generated constructor stub
    }
}
