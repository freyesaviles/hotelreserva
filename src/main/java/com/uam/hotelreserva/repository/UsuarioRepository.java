package com.uam.hotelreserva.repository;

import com.uam.hotelreserva.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
