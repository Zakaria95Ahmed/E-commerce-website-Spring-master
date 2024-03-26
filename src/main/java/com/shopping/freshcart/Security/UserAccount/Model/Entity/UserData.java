package com.shopping.freshcart.Security.UserAccount.Model.Entity;

import com.shopping.freshcart.Security.UserAccount.Model.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;

public class UserData implements UserDetails {

    @Serial
    private static final long serialVersionUID = -292405002327935093L;

    private final User user;

    public UserData(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return the user's authorities/roles
        // Implement this method based on your application's requirements
        return null;
    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return stream(this.user.getAuthorities()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Add any additional methods to access user details
    public Long getId() {
        return user.getId();
    }

    public String getEmail() {
        return user.getEmail();
    }
}

