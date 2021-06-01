package ua.kharkov.khpi.vinokurov.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.khpi.vinokurov.diploma.mapper.BasketMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.BasketDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SeatDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserDto;
import ua.kharkov.khpi.vinokurov.diploma.repository.BasketRepository;
import ua.kharkov.khpi.vinokurov.diploma.service.BasketService;
import ua.kharkov.khpi.vinokurov.diploma.service.SeatService;
import ua.kharkov.khpi.vinokurov.diploma.util.Paginator;

import java.util.List;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private SeatService seatService;
    @Autowired
    private BasketMapper basketMapper;
    @Autowired
    private Paginator paginator;

    @Override
    public boolean isExist(long id) {
        return basketRepository.existsById(id);
    }

    @Override
    public Optional<BasketDto> findByUserId(long userId) {
        return basketRepository.findByUserId(userId)
                .map(basketMapper::entityToDto);
    }


    @Override
    public Optional<BasketDto> getById(long id) {
        return basketRepository.findById(id)
                .map(basketMapper::entityToDto);
    }

    @Override
    public BasketDto getOrCreate(long userId) {
        return basketRepository.findByUserId(userId)
                .map(basketMapper::entityToDto)
                .orElseGet(() -> basketMapper.entityToDto(basketRepository.save(basketMapper.dtoToEntity(BasketDto.builder()
                        .user(UserDto.builder()
                                .id(userId)
                                .build())
                        .build()))));
    }


    @Override
    public void delete(long id) {
        basketRepository.deleteById(id);
    }

    @Override
    public Optional<BasketDto> updateSeats(long basketId, List<SeatDto> seats) {
        final Optional<BasketDto> basket = basketRepository.findById(basketId)
                .map(basketMapper::entityToDto);
        basket.ifPresent(basketDto -> basketDto.setSeat(seats));
        return basket;
    }

    @Override
    public Optional<BasketDto> addSeat(long basketId, long seatId) {
        final Optional<BasketDto> basket = basketRepository.findById(basketId)
                .map(basketMapper::entityToDto);
        basket.ifPresent(basketDto -> seatService.getById(seatId)
                .ifPresent(seat -> Optional.ofNullable(basketDto.getSeat())
                        .ifPresent(seats -> seats.add(seat))));

        return basket.map(basketMapper::dtoToEntity)
                .map(basketRepository::save)
                .map(basketMapper::entityToDto);
    }
}
