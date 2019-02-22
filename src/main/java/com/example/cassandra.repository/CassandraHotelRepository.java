package com.example.cassandra.repository;

import com.example.cassandra.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.data.cassandra.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static org.springframework.data.cassandra.core.query.Criteria.where;
import static org.springframework.data.cassandra.core.query.Query.query;

@Repository
public class CassandraHotelRepository implements HotelRepository {

	@Autowired
	private CassandraOperations cassandraTemplate;

	@Override
	public Hotel save(Hotel hotel) {
		if (hotel.getId() == null) {
			hotel.setId(UUID.randomUUID());
		}
		return cassandraTemplate.insert(hotel);
	}

	@Override
	public boolean update(Hotel hotel) {
		return cassandraTemplate.update(Query.query(where("id").is(hotel.getId())),Update.update("address", hotel.getAddress()),Hotel.class);
//		return cassandraTemplate.update(Query.query(where("id").is(hotel.getId())), Update.update("balance",50l),Hotel.class);
	}

	@Override
	public Hotel findOne(String name) {
		return cassandraTemplate.selectOne(query(where("name").is(name)).withAllowFiltering(),Hotel.class);
	}

	@Override
	public boolean delete(UUID hotelId) {
		return cassandraTemplate.deleteById(hotelId,Hotel.class);
	}

	@Override
	public List<Hotel> findByState(String state) {
//		query(where("age").is(50))
//				.and(where("balance").gt(1000.00d)).withAllowFiltering()
		return cassandraTemplate.select(query(where("state").is(state)).withAllowFiltering(),Hotel.class);
	}
}
