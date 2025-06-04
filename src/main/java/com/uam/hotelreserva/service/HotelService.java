package com.uam.hotelreserva.service;

import com.uam.hotelreserva.exception.ResourceNotFoundException;
import com.uam.hotelreserva.model.Hotel;
import com.uam.hotelreserva.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> listarTodos() {
        return hotelRepository.findAll();
    }

    public Hotel obtenerPorId(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel no encontrado con ID: " + id));
    }

    public Hotel guardar(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel actualizar(Long id, Hotel hotelDetalles) {
        Hotel hotel = obtenerPorId(id);
        hotel.setNombre(hotelDetalles.getNombre());
        hotel.setDireccion(hotelDetalles.getDireccion());
        hotel.setCiudad(hotelDetalles.getCiudad());
        return hotelRepository.save(hotel);
    }

    public void eliminar(Long id) {
        Hotel hotel = obtenerPorId(id);
        hotelRepository.delete(hotel);
    }
}
