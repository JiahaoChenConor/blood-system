package com.elec5619.bloodsystem.security;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

/**
 * The type Custom o auth 2 user.
 */
public class CustomOAuth2User implements OAuth2User {

    private OAuth2User oauth2User;

    /**
     * Instantiates a new Custom o auth 2 user.
     *
     * @param oauth2User the oauth 2 user
     */
    public CustomOAuth2User(OAuth2User oauth2User) {
        this.oauth2User = oauth2User;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oauth2User.getAuthorities();
    }

    @Override
    public String getName() {
        return oauth2User.getAttribute("name");
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return oauth2User.<String>getAttribute("email");
    }
}