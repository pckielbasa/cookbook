package com.pkielbasa.accountservice.application.exception;

import java.time.LocalDateTime;

public record ErrorMessage(
        String message,
        int status,
        LocalDateTime dateTime
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String message;
        private int status;
        private LocalDateTime dateTime;

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder dateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public ErrorMessage build() {
            return new ErrorMessage(message, status, dateTime);
        }
    }
}
