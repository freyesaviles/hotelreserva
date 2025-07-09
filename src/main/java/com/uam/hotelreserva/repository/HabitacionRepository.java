package com.uam.hotelreserva.repository;

import com.uam.hotelreserva.entity.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    List<Habitacion> findByHotelId(Long hotelId);
}
