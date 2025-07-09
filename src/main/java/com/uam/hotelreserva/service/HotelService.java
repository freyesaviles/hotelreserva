package com.uam.hotelreserva.service;

import com.uam.hotelreserva.dto.HabitacionDto;
import com.uam.hotelreserva.dto.HotelDto;
import com.uam.hotelreserva.entity.Habitacion;
import com.uam.hotelreserva.entity.Hotel;
import com.uam.hotelreserva.repository.HabitacionRepository;
import com.uam.hotelreserva.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HabitacionRepository habitacionRepository;

    public HotelService(HotelRepository hotelRepository, HabitacionRepository habitacionRepository) {
        this.hotelRepository = hotelRepository;
        this.habitacionRepository = habitacionRepository;
    }

    public List<HotelDto> getAllHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(hotel -> {
                    HotelDto dto = new HotelDto();
                    dto.id = hotel.getId();
                    dto.nombre = hotel.getNombre();
                    dto.direccion = hotel.getDireccion();
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<HabitacionDto> getHabitacionesByHotelId(Long hotelId) {
        List<Habitacion> habitaciones = habitacionRepository.findByHotelId(hotelId);
        return habitaciones.stream().map(habitacion -> {
            HabitacionDto dto = new HabitacionDto();
            dto.id = habitacion.getId();
            dto.tipo = habitacion.getTipo();
            dto.precio = habitacion.getPrecio();
            dto.disponible = habitacion.isDisponible();
            return dto;
        }).collect(Collectors.toList());
    }
}
