package com.opso.med.security;

/**
 * Constants for Spring Security authorities.
 */
public final class AuthoritiesConstants {

    public static final String ADMIN = "ROLE_ADMIN";

    public static final String USER = "ROLE_USER";

    public static final String ANONYMOUS = "ROLE_ANONYMOUS";

    public static final String EXPERT = "ROLE_EXPERT";

    public static final String OFFICE = "ROLE_OFFICE";

    private AuthoritiesConstants() {
    }
}
