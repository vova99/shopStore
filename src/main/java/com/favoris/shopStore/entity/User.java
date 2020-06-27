package com.favoris.shopStore.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "usr")
@Data
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Role roles = Role.USER;
    private String firstName;
    private String secondName;
    private String password;
    private String username;
    private boolean active;

    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired= true;
    private boolean enabled = true;

    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(roles.toString()));
        return authorities;
    }

    public boolean isEnabled() {
        return enabled;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public Role getRoles() {
        return roles;
    }
}
