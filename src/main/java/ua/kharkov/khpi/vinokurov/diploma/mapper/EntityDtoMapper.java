package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Named;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Optional;

public interface EntityDtoMapper<E, D> {
    String ERASE_PASSWORD = "erasePassword";

    E dtoToEntity(D dto);

    D entityToDto(E entity);

    default LocalTime map(Time time) {
        return time.toLocalTime();
    }

    default Time map(LocalTime localTime) {
        return Optional.ofNullable(localTime)
                .map(Time::valueOf)
                .orElse(null);
    }

    @Named(ERASE_PASSWORD)
    default String erasePassword(String password) {
        return "";
    }
}
