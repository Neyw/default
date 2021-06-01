package ua.kharkov.khpi.vinokurov.diploma.model.converter;

import ua.kharkov.khpi.vinokurov.diploma.model.enums.SeatType;

import javax.persistence.Converter;
import java.util.Optional;

@Converter(autoApply = true)
public class SeatTypeConverter extends StringEnumConverter<SeatType> {
    @Override
    public SeatType convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData)
                .map(SeatType::valueOf)
                .orElse(null);
    }

}
