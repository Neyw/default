package ua.kharkov.khpi.vinokurov.diploma.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDataDto {
    private long id;
    private int number;
    private int expireMonth;
    private int expireYear;
    private String name;
    private String lastName;
    private int cvv;
}
