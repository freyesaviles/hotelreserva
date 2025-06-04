package com.uam.hotelreserva.repository;

import com.uam.hotelreserva.model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
}
