package com.pkielbasa.accountservice.api.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Component
public class UriBuilder {
    public static URI generateLocation(Long id) {
        if (id == null || id <0) {
            throw new IllegalArgumentException("Cannot build URI with null or negative id.");
        }
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id")
                .buildAndExpand(id)
                .toUri();
    }
}
