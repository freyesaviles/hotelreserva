package com.uam.hotelreserva.auth;

import com.uam.hotelreserva.UsuarioDTO.LoginRequest;
import com.uam.hotelreserva.UsuarioDTO.LoginResponse;
import com.uam.hotelreserva.config.JwtUtil;
import com.uam.hotelreserva.model.Usuario;
import com.uam.hotelreserva.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Usuario usuario = usuarioRepository.findByCorreo(request.getCorreo());
        if (usuario == null || !usuario.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }

        String token = jwtUtil.generateToken(usuario.getCorreo());
        return ResponseEntity.ok(new LoginResponse(token, usuario.getNombre()));
    }
}