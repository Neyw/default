package ua.kharkov.khpi.vinokurov.diploma.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SingleFlightDto {
    private long id;
    private RouteDto route;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private PlaneDto plane;
    private List<SeatDto> seat;
}
