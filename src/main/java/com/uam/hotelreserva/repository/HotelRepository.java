package com.uam.hotelreserva.repository;

import com.uam.hotelreserva.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
