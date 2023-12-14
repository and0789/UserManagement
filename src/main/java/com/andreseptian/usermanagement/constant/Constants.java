package com.andreseptian.usermanagement.constant;

public class Constants {
    // Security

    // Password Encoder Config
    public static final int STRENGTH = 12;

    // Security Config
    public static final String[] PUBLIC_URLS = {
            "/user/verify/password/**",
            "/user/login/**",
            "/user/verify/code/**",
            "/user/register/**",
            "/user/resetpassword/**",
            "/user/verify/account/**",
            "/user/refresh/token/**",
            "/user/image/**",
            "/user/new/password/**"
    };

    // CustomAuthorizationFilter
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String[] PUBLIC_ROUTES = { "/user/new/password", "/user/login", "/user/verify/code", "/user/register", "/user/refresh/token", "/user/image" };
    public static final String HTTP_OPTIONS_METHOD = "OPTIONS";


    // TokenProvider
    public static final String AUTHORITIES = "authorities";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String ANDRE_SEPTIAN_APPLICATION = "ANDRE_SEPTIAN_APPLICATION";
    public static final String CUSTOMER_MANAGEMENT_SERVICE = "CUSTOMER_MANAGEMENT_SERVICE";
    public static final long ACCESS_TOKEN_EXPIRATION_TIME = 86_400_000; // 30_000; //
    public static final long REFRESH_TOKEN_EXPIRATION_TIME = 432_000_000;


    // RequestUtils
    public static final String USER_AGENT_HEADER = "user-agent";
    public static final String X_FORWARDED_FOR_HEADER = "X-FORWARDED-FOR";

    // Date
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSSSSS";


}
