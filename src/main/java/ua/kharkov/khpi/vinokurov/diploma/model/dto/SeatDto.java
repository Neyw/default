package ua.kharkov.khpi.vinokurov.diploma.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.minified.MinifiedBasketDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.minified.MinifiedSingleFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.SeatType;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatDto {
    private long id;
    private int number;
    private BigDecimal price;
    private SeatType type;
    private UserDto user;
    private MinifiedSingleFlightDto singleFlight;
    private MinifiedBasketDto basket;
}
