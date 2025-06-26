package com.HotelBookingSystem.example.Hotel.dao;

import com.HotelBookingSystem.example.Hotel.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
