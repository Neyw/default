package ua.kharkov.khpi.vinokurov.diploma.model.converter;

import javax.persistence.AttributeConverter;
import java.util.Objects;
import java.util.Optional;

public abstract class StringEnumConverter<T extends Enum<T>> implements AttributeConverter<T, String> {
    @Override
    public String convertToDatabaseColumn(T attribute) {
        return Optional.ofNullable(attribute)
                .map(Objects::toString)
                .orElse(null);
    }
}
