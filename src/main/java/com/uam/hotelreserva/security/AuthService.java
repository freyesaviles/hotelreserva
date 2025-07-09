package com.uam.hotelreserva.security;

import com.uam.hotelreserva.entity.Usuario;
import com.uam.hotelreserva.repository.UsuarioRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepo;
    private final JwtUtil jwtUtil;

    public AuthService(UsuarioRepository usuarioRepo, JwtUtil jwtUtil) {
        this.usuarioRepo = usuarioRepo;
        this.jwtUtil = jwtUtil;
    }

    public String authenticate(String username, String password) {
        Usuario user = usuarioRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        if (!user.getPassword().equals(password)) {
            throw new BadCredentialsException("Credenciales inválidas");
        }

        return jwtUtil.generateToken(username);
    }
}
