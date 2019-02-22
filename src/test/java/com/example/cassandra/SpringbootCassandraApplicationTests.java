package com.example.cassandra;

import com.example.cassandra.model.Hotel;
import com.example.cassandra.repository.HotelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCassandraApplicationTests {
	@Autowired
	private HotelRepository repository;
	@Test
	public void addHotel() {
		Hotel hotel = new Hotel();
		hotel.setName("7天");
		hotel.setAddress("潍坊市");
		hotel.setState("active");
		Hotel h = repository.save(hotel);
		System.out.println("cassandra="+h.toString());
	}

	@Test
	public void updateHotel() {
		Hotel hotel = new Hotel();
		hotel.setId(UUID.fromString("4c0f6cb9-fb5f-4c3e-a5d1-20dda08ffdc8"));
		hotel.setAddress("北京市");
		boolean h = repository.update(hotel);
		System.out.println("cassandra="+h);
	}

	@Test
	public  void findOne(){
		Hotel h = repository.findOne("active");
		System.out.println("cassandra="+h.toString());
	}

	@Test
	public  void findAll(){
		List<Hotel> h = repository.findByState("active");
		h.forEach(hotel -> System.out.println(hotel.toString()));
	}

	@Test
	public void delete(){
		boolean b = repository.delete(UUID.fromString("a5726f70-7df4-4431-ad1d-82e1f860bfbe"));
		System.out.println(b);
	}
}
