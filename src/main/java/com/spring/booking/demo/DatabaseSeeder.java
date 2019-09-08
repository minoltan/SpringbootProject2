package com.spring.booking.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DatabaseSeeder implements CommandLineRunner {
    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<HotelBooking> bookings = new ArrayList<>();

        bookings.add(new HotelBooking("Agape", 100.50, 5));
        bookings.add(new HotelBooking("Ocean", 150.20, 4));
        bookings.add(new HotelBooking("Julie", 200.00, 5));

        bookingRepository.saveAll(bookings);

    }
}
