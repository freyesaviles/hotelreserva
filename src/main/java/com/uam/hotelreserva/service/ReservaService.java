package com.uam.hotelreserva.service;

import com.uam.hotelreserva.exception.ResourceNotFoundException;
import com.uam.hotelreserva.model.Reserva;
import com.uam.hotelreserva.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    public Reserva obtenerPorId(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con ID: " + id));
    }

    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva actualizar(Long id, Reserva datos) {
        Reserva reserva = obtenerPorId(id);
        reserva.setFechaInicio(datos.getFechaInicio());
        reserva.setFechaFin(datos.getFechaFin());
        reserva.setUsuario(datos.getUsuario());
        reserva.setHabitacion(datos.getHabitacion());
        return reservaRepository.save(reserva);
    }

    public void eliminar(Long id) {
        Reserva reserva = obtenerPorId(id);
        reservaRepository.delete(reserva);
    }
}
