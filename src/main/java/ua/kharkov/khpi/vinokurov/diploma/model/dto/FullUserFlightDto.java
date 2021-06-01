package ua.kharkov.khpi.vinokurov.diploma.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class FullUserFlightDto {
    private long id;
    private String name;
    private UserDto user;
    private List<UserFlightDto> userFlight;
}
