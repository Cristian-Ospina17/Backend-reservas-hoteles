package com.hotelapp.hotelbackend.repository;

import com.hotelapp.hotelbackend.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findByCiudadIgnoreCase(String ciudad);
}