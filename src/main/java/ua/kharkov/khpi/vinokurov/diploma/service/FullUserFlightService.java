package ua.kharkov.khpi.vinokurov.diploma.service;

import ua.kharkov.khpi.vinokurov.diploma.model.dto.FullUserFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserFlightDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface FullUserFlightService {

    List<FullUserFlightDto> getAllByUserId(long userId);

    Optional<FullUserFlightDto> getById(long id);

    FullUserFlightDto add(FullUserFlightDto fullUserFlightDto);

    Optional<FullUserFlightDto> add(List<UserFlightDto> userFlights, long userId);

    Optional<BigDecimal> countPrice(long fullUserFlightId);

    void delete(long id);
}
