package com.example.HotelApp.mapper;


import com.example.HotelApp.dto.request.HotelRequest;
import com.example.HotelApp.dto.response.HotelListResponse;
import com.example.HotelApp.dto.response.HotelResponse;
import com.example.HotelApp.mapper.delegate.HotelDelegate;
import com.example.HotelApp.model.Hotel;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@DecoratedWith(HotelDelegate.class)
@Mapper(componentModel = "string", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface HotelMapper {

    Hotel hotelRequestToHotel(HotelRequest hotelRequest);

    @Mapping(source = "hotelId", target = "id")
    Hotel hotelRequestToHotel(Long hotelId, HotelRequest hotelRequest);

    HotelResponse hotelToHotelResponse(Hotel hotel);

    List<HotelResponse> hotelListToHotelListResponse(List<Hotel> hotels);

    default HotelListResponse hotelListToListResponse(List<Hotel> hotels) {
        HotelListResponse hotelListResponse = new HotelListResponse();
        hotelListResponse.setHotels(hotelListToHotelListResponse(hotels));
        return hotelListResponse;
    }

}
