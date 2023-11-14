package com.example.ticket_football.common;

public class Constants {
    public enum Roles {
        ROLE_USER,
        ROLE_ADMIN
    }

    public enum Code {

        OK(2000),
        LOGGED_IN(2001),
        CREATED_SUCCESS(2002),
        SIGNUP_SUCCESSFUL(2003),
        UPDATE_SUCCESSFUL(2005),
        DELETE_SUCCESSFUL(2006),
        INVALID(4001),
        PASSWORD_NOT_MATCHES(4002),
        EMAIL_EXISTED(4003),
        EXISTED(4008),
        NOT_EXISTED(4007),
        USER_NOT_EXISTED(4011);

        private long code;
        Code(long code) {this.code = code;}
        public long getCode() {
            return code;
        }
    }
}
