package com.uam.hotelreserva.util;

import com.uam.hotelreserva.entity.Habitacion;
import com.uam.hotelreserva.entity.Hotel;
import com.uam.hotelreserva.entity.Usuario;
import com.uam.hotelreserva.repository.HabitacionRepository;
import com.uam.hotelreserva.repository.HotelRepository;
import com.uam.hotelreserva.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final HotelRepository hotelRepo;
    private final HabitacionRepository habitacionRepo;
    private final UsuarioRepository usuarioRepo;

    public DataSeeder(HotelRepository hotelRepo, HabitacionRepository habitacionRepo, UsuarioRepository usuarioRepo) {
        this.hotelRepo = hotelRepo;
        this.habitacionRepo = habitacionRepo;
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (hotelRepo.count() == 0) {
            Hotel hotel1 = new Hotel();
            hotel1.setNombre("Hotel Pacífico");
            hotel1.setDireccion("Av. Costera 123");
            hotelRepo.save(hotel1);

            Hotel hotel2 = new Hotel();
            hotel2.setNombre("Hotel Central");
            hotel2.setDireccion("Calle Principal 456");
            hotelRepo.save(hotel2);

            Habitacion hab1 = new Habitacion();
            hab1.setTipo("Individual");
            hab1.setPrecio(45.0);
            hab1.setDisponible(true);
            hab1.setHotel(hotel1);
            habitacionRepo.save(hab1);

            Habitacion hab2 = new Habitacion();
            hab2.setTipo("Doble");
            hab2.setPrecio(70.0);
            hab2.setDisponible(true);
            hab2.setHotel(hotel1);
            habitacionRepo.save(hab2);

            Habitacion hab3 = new Habitacion();
            hab3.setTipo("Suite");
            hab3.setPrecio(120.0);
            hab3.setDisponible(true);
            hab3.setHotel(hotel2);
            habitacionRepo.save(hab3);
        }

        if (usuarioRepo.count() == 0) {
            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword("1234");
            usuarioRepo.save(admin);
        }
    }
}
