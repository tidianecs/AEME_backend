package com.daust.aeme_backend.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.daust.aeme_backend.auth.service.KeycloakService;
import com.daust.aeme_backend.auth.DTO.signupRequest;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private final KeycloakService keycloakService;

    public AuthController(KeycloakService keycloakService) {
        this.keycloakService = keycloakService;
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<?> signup(@RequestBody signupRequest request) {
        keycloakService.createUser(
                request.getUserName(),
                request.getUserEmail(),
                request.getUserPassword()
        );

        return ResponseEntity.ok("User created");
    }
}
