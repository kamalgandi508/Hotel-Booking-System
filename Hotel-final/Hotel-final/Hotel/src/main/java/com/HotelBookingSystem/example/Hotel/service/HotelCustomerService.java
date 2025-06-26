package com.HotelBookingSystem.example.Hotel.service;

import com.HotelBookingSystem.example.Hotel.dao.CustomerRepository;
import com.HotelBookingSystem.example.Hotel.dao.HotelRepository;
import com.HotelBookingSystem.example.Hotel.entity.Customer;
import com.HotelBookingSystem.example.Hotel.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelCustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private HotelRepository hotelRepository;

    // Customer Methods
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(int customerId) {
        return customerRepository.findById(customerId);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(int customerId, Customer customer) {
        customer.setCustomerId(customerId);
        return customerRepository.save(customer);
    }

    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }

    // Hotel Methods
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> getHotelById(int hotelId) {
        return hotelRepository.findById(hotelId);
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(int hotelId, Hotel hotel) {
        hotel.setHotelId(hotelId);
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(int hotelId) {
        hotelRepository.deleteById(hotelId);
    }
}
