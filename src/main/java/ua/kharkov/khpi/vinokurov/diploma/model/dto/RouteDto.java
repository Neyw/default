package ua.kharkov.khpi.vinokurov.diploma.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RouteDto {
    private long id;
    private String name;
    private StationDto startStation;
    private StationDto endStation;
    private LocalTime startTime;
    private LocalTime endTime;
}
