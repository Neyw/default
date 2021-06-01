package ua.kharkov.khpi.vinokurov.diploma.service;

import ua.kharkov.khpi.vinokurov.diploma.model.dto.SeatDto;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.SeatType;

import java.util.List;
import java.util.Optional;

public interface SeatService {

    List<SeatDto> findAllByUser(long userId);

    List<SeatDto> findAllByBasket(long basketId);

    Optional<SeatDto> getById(long id);

    SeatDto add(SeatDto seat);

    void delete(long id);

    Optional<SeatDto> changeUser(long seatId, long userId);

    Optional<SeatDto> changeType(long seatId, SeatType seatType);
}
