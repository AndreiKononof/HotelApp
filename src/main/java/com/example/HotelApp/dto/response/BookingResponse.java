package com.example.HotelApp.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingResponse {

    private String roomName;

    private String userName;

    private LocalDate dateEntry;

    private LocalDate dateExit;

}
