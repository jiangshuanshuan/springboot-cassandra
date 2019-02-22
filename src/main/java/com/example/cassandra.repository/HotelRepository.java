package com.example.cassandra.repository;

import com.example.cassandra.model.Hotel;

import java.util.List;
import java.util.UUID;

public interface HotelRepository {
	Hotel save(Hotel hotel);
	boolean update(Hotel hotel);
	Hotel findOne(String name);
	boolean delete(UUID hotelId);
	List<Hotel> findByState(String state);
}
