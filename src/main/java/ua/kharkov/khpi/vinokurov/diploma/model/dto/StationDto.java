package ua.kharkov.khpi.vinokurov.diploma.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StationDto {
    private long id;
    private String name;
    private String address;
    private CityDto city;
}
