package com.uam.hotelreserva.controller;

import com.uam.hotelreserva.dto.ReservaDto;
import com.uam.hotelreserva.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<?> crearReserva(@RequestBody ReservaDto dto) {
        reservaService.crearReserva(dto);
        return ResponseEntity.ok().build();
    }
}
