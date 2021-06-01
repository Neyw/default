package ua.kharkov.khpi.vinokurov.diploma.model.dto.minified;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.PlaneDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.RouteDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SeatDto;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MinifiedSingleFlightDto {
    private long id;
    private RouteDto route;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private PlaneDto plane;
}
