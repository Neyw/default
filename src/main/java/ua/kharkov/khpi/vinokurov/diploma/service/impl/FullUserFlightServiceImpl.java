package ua.kharkov.khpi.vinokurov.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.khpi.vinokurov.diploma.mapper.FullUserFlightMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.FullUserFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SeatDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.repository.FullUserFlightRepository;
import ua.kharkov.khpi.vinokurov.diploma.service.FullUserFlightService;
import ua.kharkov.khpi.vinokurov.diploma.service.UserFlightService;
import ua.kharkov.khpi.vinokurov.diploma.service.UserService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FullUserFlightServiceImpl implements FullUserFlightService {
    @Autowired
    private FullUserFlightRepository fullUserFlightRepository;
    @Autowired
    private FullUserFlightMapper fullUserFlightMapper;
    @Autowired
    private UserFlightService userFlightService;
    @Autowired
    private UserService userService;

    @Override
    public List<FullUserFlightDto> getAllByUserId(long userId) {
        return fullUserFlightRepository.getAllByUserId(userId)
                .stream()
                .map(fullUserFlightMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FullUserFlightDto> getById(long id) {
        return fullUserFlightRepository.findById(id)
                .map(fullUserFlightMapper::entityToDto);
    }

    @Override
    public FullUserFlightDto add(FullUserFlightDto fullUserFlightDto) {
        return fullUserFlightMapper.entityToDto(fullUserFlightRepository.save(fullUserFlightMapper.dtoToEntity(fullUserFlightDto)));
    }

    @Override
    public Optional<FullUserFlightDto> add(List<UserFlightDto> userFlights, long userId) {
        return userService.getById(userId)
                .map(userDto -> FullUserFlightDto.builder()
                        .userFlight(userFlights)
                        .user(userDto)
                        .build())
                .map(this::add);
    }

    @Override
    public Optional<BigDecimal> countPrice(long fullUserFlightId) {
        return getById(fullUserFlightId).map(fullUserFlight -> fullUserFlight.getUserFlight().stream()
                .map(userFlightDto -> userFlightDto.getSingleFlight().getSeat().get(userFlightDto.getSeat()))
                .map(SeatDto::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
        );
    }

    @Override
    public void delete(long id) {
        fullUserFlightRepository.deleteById(id);
    }
}
