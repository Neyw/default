package ua.kharkov.khpi.vinokurov.diploma.service;

import ua.kharkov.khpi.vinokurov.diploma.model.dto.SingleFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserFlightDto;

import java.util.List;
import java.util.Optional;

public interface UserFlightService {

    List<UserFlightDto> getAllByUserId(long userId);

    Optional<UserFlightDto> getById(long id);

    List<UserFlightDto> getAllByIds(List<Long> ids);

    UserFlightDto add(UserFlightDto userFlightDto);

    UserFlightDto add(SingleFlightDto singleFlightDto, int seat);

    void delete(long id);
}
