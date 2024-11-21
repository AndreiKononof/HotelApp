package com.example.HotelApp.dto.response.responseList;

import com.example.HotelApp.dto.response.BookingResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookingListResponse {

    private List<BookingResponse> bookingResponses = new ArrayList<>();
}
