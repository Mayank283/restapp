package org.mayank.restapp.simple.security;

import java.io.Serializable;

public class JwtUserResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtUserResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
