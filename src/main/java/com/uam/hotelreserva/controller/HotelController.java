package com.uam.hotelreserva.controller;

import com.uam.hotelreserva.model.Hotel;
import com.uam.hotelreserva.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
@CrossOrigin(origins = "*")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Hotel> listar() {
        return hotelService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Hotel> crear(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.guardar(hotel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> actualizar(@PathVariable Long id, @RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.actualizar(id, hotel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        hotelService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
