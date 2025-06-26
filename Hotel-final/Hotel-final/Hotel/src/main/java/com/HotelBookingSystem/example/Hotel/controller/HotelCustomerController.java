package com.HotelBookingSystem.example.Hotel.controller;

import com.HotelBookingSystem.example.Hotel.entity.Customer;
import com.HotelBookingSystem.example.Hotel.entity.Hotel;
import com.HotelBookingSystem.example.Hotel.service.HotelCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HotelCustomerController {
    @Autowired
    private HotelCustomerService hotelCustomerService;

    // Customer Endpoints
    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return hotelCustomerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Optional<Customer> customer = hotelCustomerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = hotelCustomerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        Optional<Customer> existingCustomer = hotelCustomerService.getCustomerById(id);
        if (existingCustomer.isPresent()) {
            customer.setCustomer_id(id);
            Customer updatedCustomer = hotelCustomerService.updateCustomer(id, customer);
            return ResponseEntity.ok(updatedCustomer);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        if (hotelCustomerService.getCustomerById(id).isPresent()) {
            hotelCustomerService.deleteCustomer(id);
            return ResponseEntity.status(HttpStatus.OK).body("Customer deleted successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found!");
    }

    // Hotel Endpoints
    @GetMapping("/hotel")
    public List<Hotel> getAllHotels() {
        return hotelCustomerService.getAllHotels();
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable int id) {
        Optional<Hotel> hotel = hotelCustomerService.getHotelById(id);
        return hotel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
//add the values
    @PostMapping("/hotel")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelCustomerService.addHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
    }
//update the values
    @PutMapping("/hotel/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable int id, @RequestBody Hotel hotel) {
        if (hotelCustomerService.getHotelById(id).isPresent()) {
            Hotel updatedHotel = hotelCustomerService.updateHotel(id, hotel);
            return ResponseEntity.ok(updatedHotel);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
//delete the row
    @DeleteMapping("/hotel/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable int id) {
        if (hotelCustomerService.getHotelById(id).isPresent()) {
            hotelCustomerService.deleteHotel(id);
            return ResponseEntity.status(HttpStatus.OK).body("Hotel deleted successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel not found!");
    }
}

