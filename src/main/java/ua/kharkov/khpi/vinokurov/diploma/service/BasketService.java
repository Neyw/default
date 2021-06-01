package ua.kharkov.khpi.vinokurov.diploma.service;

import ua.kharkov.khpi.vinokurov.diploma.model.dto.BasketDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SeatDto;

import java.util.List;
import java.util.Optional;

public interface BasketService {
    boolean isExist(long id);

    Optional<BasketDto> findByUserId(long userId);

    Optional<BasketDto> getById(long id);

    BasketDto getOrCreate(long userId);

    void delete(long id);

    Optional<BasketDto> updateSeats(long basketId, List<SeatDto> seats);

    Optional<BasketDto> addSeat(long basketId, long seatId);
}
