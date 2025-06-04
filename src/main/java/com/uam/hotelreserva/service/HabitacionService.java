package com.uam.hotelreserva.service;

import com.uam.hotelreserva.exception.ResourceNotFoundException;
import com.uam.hotelreserva.model.Habitacion;
import com.uam.hotelreserva.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    public List<Habitacion> listarTodas() {
        return habitacionRepository.findAll();
    }

    public Habitacion obtenerPorId(Long id) {
        return habitacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habitación no encontrada con ID: " + id));
    }

    public Habitacion guardar(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    public Habitacion actualizar(Long id, Habitacion datos) {
        Habitacion habitacion = obtenerPorId(id);
        habitacion.setTipo(datos.getTipo());
        habitacion.setPrecio(datos.getPrecio());
        habitacion.setDisponible(datos.getDisponible());
        habitacion.setHotel(datos.getHotel());
        return habitacionRepository.save(habitacion);
    }

    public void eliminar(Long id) {
        Habitacion habitacion = obtenerPorId(id);
        habitacionRepository.delete(habitacion);
    }
}
