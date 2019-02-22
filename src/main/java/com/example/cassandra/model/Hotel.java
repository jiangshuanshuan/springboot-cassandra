package com.example.cassandra.model;


import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("hotels")
@Data
public class Hotel {
	@PrimaryKey
	private UUID id;

	private String name;

	private String address;

	private String state;

	private String zip;

	public Hotel() {
	}

	@Override
	public String toString() {
		return "Hotel{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", state='" + state + '\'' +
				", zip='" + zip + '\'' +
				'}';
	}
}
