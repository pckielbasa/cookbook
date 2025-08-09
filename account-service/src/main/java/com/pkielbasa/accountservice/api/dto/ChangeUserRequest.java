package com.pkielbasa.accountservice.api.dto;

public record ChangeUserRequest(
        String username,
        String email) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String username;
        private String email;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;

            return this;
        }

        public ChangeUserRequest build() {
            return new ChangeUserRequest(username, email);
        }
    }
}
