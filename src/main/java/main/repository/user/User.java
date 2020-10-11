package main.repository.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@AllArgsConstructor
public class User implements UserDetails {

    private String id;
    private String username;
    private String password;
    private boolean accountExpired;
    private boolean locked;
    private boolean passwordExpired;
    private boolean enabled;
    private Set<Authority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !accountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !passwordExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Data
    @AllArgsConstructor
    public static class Authority implements GrantedAuthority {

        private String authority;

        @Override
        public String getAuthority() {
            return authority;
        }
    }
}
