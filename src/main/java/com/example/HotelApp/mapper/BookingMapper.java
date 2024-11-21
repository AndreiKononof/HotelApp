package com.example.HotelApp.mapper;


import com.example.HotelApp.dto.request.BookingRequest;
import com.example.HotelApp.dto.response.BookingResponse;
import com.example.HotelApp.dto.response.responseList.BookingListResponse;
import com.example.HotelApp.mapper.delegate.BookingDelegate;
import com.example.HotelApp.model.Booking;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@DecoratedWith(BookingDelegate.class)
@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BookingMapper {



    Booking bookingRequestToBooking (BookingRequest bookingRequest);

    BookingResponse bookingToBookingResponse (Booking booking);

    List<BookingResponse> bookingListToListResponse (List<Booking> bookings);

    default BookingListResponse bookingListToBookingListResponse (List<Booking> bookings){
        BookingListResponse response = new BookingListResponse();
        response.setBookingResponses(bookingListToListResponse(bookings));
        return response;
    }




}
