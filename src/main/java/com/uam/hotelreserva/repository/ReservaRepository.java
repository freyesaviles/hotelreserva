package com.uam.hotelreserva.repository;

import com.uam.hotelreserva.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
