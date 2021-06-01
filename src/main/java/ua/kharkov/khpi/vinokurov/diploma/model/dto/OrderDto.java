package ua.kharkov.khpi.vinokurov.diploma.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.OrderStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private long id;
    private OrderStatus orderStatus;
    private UserDto user;
    private List<UserFlightDto> userFlight;
    private PaymentInfoDto paymentInfo;
}
