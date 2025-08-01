package com.pkielbasa.accountservice.api.dto;

public record UserRequest(
        String username,
        String password,
        String email) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String username;
        private String password;
        private String email;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email) {
            this.email = email;

            return this;
        }

        public UserRequest build() {
            return new UserRequest(username, password, email);
        }
    }
}
