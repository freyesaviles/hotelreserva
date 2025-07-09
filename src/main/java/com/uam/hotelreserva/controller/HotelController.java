package com.uam.hotelreserva.controller;

import com.uam.hotelreserva.dto.HabitacionDto;
import com.uam.hotelreserva.dto.HotelDto;
import com.uam.hotelreserva.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<HotelDto> getAll() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{hotelId}/habitaciones")
    public List<HabitacionDto> getHabitaciones(@PathVariable Long hotelId) {
        return hotelService.getHabitacionesByHotelId(hotelId);
    }
}
