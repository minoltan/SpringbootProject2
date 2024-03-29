package com.spring.booking.demo;


import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
@Api(
        name = "Hotel Booking API",
        description = "Provides a list of methods that manage hotel bookings",
        stage = ApiStage.RC)
public class BookingController {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/all" )
    @ApiMethod(description = "Get all hotel bookings from the database")
    public List<HotelBooking> getAll(){
        return bookingRepository.findAll();
    }

    @GetMapping("/affordable/{price}")
    @ApiMethod(description = "Get all hotel bookings where the price per night is less than the provided value")
    public List<HotelBooking> getAffordable(@ApiPathParam(name = "price") @PathVariable double price){
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @PostMapping("/create" )
    @ApiMethod(description = "Create a hotel booking and save it to the database")
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
        bookingRepository.save(hotelBooking);

        return bookingRepository.findAll();
    }

    @PostMapping("/delete/{id}")
    @ApiMethod(description = "Remove the hotel booking with the provided ID from the database")
    public List<HotelBooking> remove(@ApiPathParam(name = "id") @PathVariable long id){
        bookingRepository.deleteById(id);

        return bookingRepository.findAll();
    }
}
