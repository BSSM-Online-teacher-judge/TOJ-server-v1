package com.toj.teacheronlinejudge.global.security.jwt;

public class JwtProperties {
    public static final long ACCESS_TOKEN_VALID_TIME = 1000 * 60 * 30L;
    public static final long REFRESH_TOKEN_VALID_TIME = 1000 * 60 * 60 * 24 * 30L;
    public static final String JWT_PREFIX = "Bearer";
    public static final String JWT_HEADER = "Authorization";
}
