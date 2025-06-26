package com.HotelBookingSystem.example.Hotel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private int hotelId; // Unique identifier for each hotel

    @Column(name = "hotel_name", nullable = false) // hotel_name column with NOT NULL constraint
    private String hotelName;

    @Column(name = "address") // address column
    private String address;

    @Column(name = "city") // city column
    private String city;

    @Column(name = "country") // country column
    private String country;

    @Column(name = "phone_number") // phone_number column
    private String phoneNumber;

    // Constructor to initialize the Hotel object
    public Hotel() {
    }

    public Hotel(int hotelId, String hotelName, String address, String city, String country, String phoneNumber) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

