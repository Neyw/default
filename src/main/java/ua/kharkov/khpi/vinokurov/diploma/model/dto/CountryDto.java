package ua.kharkov.khpi.vinokurov.diploma.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryDto {
    private long id;
    private String name;
}
