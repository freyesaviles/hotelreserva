package com.uam.hotelreserva.controller;

import com.uam.hotelreserva.dto.JwtResponse;
import com.uam.hotelreserva.dto.LoginRequest;
import com.uam.hotelreserva.security.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = authService.authenticate(request.username, request.password);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
