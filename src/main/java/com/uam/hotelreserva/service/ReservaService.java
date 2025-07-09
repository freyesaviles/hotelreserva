package com.uam.hotelreserva.service;

import com.uam.hotelreserva.dto.ReservaDto;
import com.uam.hotelreserva.entity.Habitacion;
import com.uam.hotelreserva.entity.Reserva;
import com.uam.hotelreserva.repository.HabitacionRepository;
import com.uam.hotelreserva.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final HabitacionRepository habitacionRepository;

    public ReservaService(ReservaRepository reservaRepository, HabitacionRepository habitacionRepository) {
        this.reservaRepository = reservaRepository;
        this.habitacionRepository = habitacionRepository;
    }

    public void crearReserva(ReservaDto dto) {
        Habitacion habitacion = habitacionRepository.findById(dto.habitacionId)
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));

        Reserva reserva = new Reserva();
        reserva.setHabitacion(habitacion);
        reserva.setNombreCliente(dto.nombreCliente);
        reserva.setCorreoCliente(dto.correoCliente);
        reserva.setFechaInicio(LocalDate.parse(dto.fechaInicio));
        reserva.setFechaFin(LocalDate.parse(dto.fechaFin));

        reservaRepository.save(reserva);
    }
}
