package ua.kharkov.khpi.vinokurov.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.khpi.vinokurov.diploma.mapper.BasketMapper;
import ua.kharkov.khpi.vinokurov.diploma.mapper.SeatMapper;
import ua.kharkov.khpi.vinokurov.diploma.mapper.UserMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.BasketDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SeatDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserDto;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.SeatType;
import ua.kharkov.khpi.vinokurov.diploma.repository.SeatRepository;
import ua.kharkov.khpi.vinokurov.diploma.service.BasketService;
import ua.kharkov.khpi.vinokurov.diploma.service.SeatService;
import ua.kharkov.khpi.vinokurov.diploma.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private SeatMapper seatMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BasketMapper basketMapper;
    @Autowired
    private BasketService basketService;
    @Autowired
    private UserService userService;

    @Override
    public List<SeatDto> findAllByUser(long userId) {
        return seatRepository.findAllByUser(userMapper.dtoToEntity(UserDto.builder()
                .id(userId)
                .build()))
                .stream()
                .map(seatMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SeatDto> findAllByBasket(long basketId) {
        return basketService.getById(basketId)
                .map(BasketDto::getSeat)
                .orElse(new ArrayList<>());
    }

    @Override
    public Optional<SeatDto> getById(long id) {
        return seatRepository.findById(id)
                .map(seatMapper::entityToDto);
    }

    @Override
    public SeatDto add(SeatDto seat) {
        return seatMapper.entityToDto(seatRepository.save(seatMapper.dtoToEntity(seat)));
    }

    @Override
    public void delete(long id) {
        seatRepository.deleteById(id);
    }

    @Override
    public Optional<SeatDto> changeUser(long seatId, long userId) {
        final Optional<SeatDto> seatDto = getById(seatId);
        seatDto.ifPresent(seat -> userService.getById(userId)
                .ifPresent(seat::setUser));

        return seatDto.map(seatMapper::dtoToEntity)
                .map(seatRepository::save)
                .map(seatMapper::entityToDto);
    }

    @Override
    public Optional<SeatDto> changeType(long seatId, SeatType seatType) {
        final Optional<SeatDto> seatDto = getById(seatId);
        seatDto.ifPresent(seat -> seat.setType(seatType));

        return seatDto.map(seatMapper::dtoToEntity)
                .map(seatRepository::save)
                .map(seatMapper::entityToDto);
    }
}
