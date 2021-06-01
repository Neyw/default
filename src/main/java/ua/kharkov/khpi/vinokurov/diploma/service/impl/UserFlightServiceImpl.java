package ua.kharkov.khpi.vinokurov.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.khpi.vinokurov.diploma.mapper.UserFlightMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SingleFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.repository.UserFlightRepository;
import ua.kharkov.khpi.vinokurov.diploma.service.UserFlightService;
import ua.kharkov.khpi.vinokurov.diploma.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserFlightServiceImpl implements UserFlightService {
    @Autowired
    private UserFlightRepository userFlightRepository;
    @Autowired
    private UserFlightMapper userFlightMapper;
    @Autowired
    private UserService userService;

    @Override
    public List<UserFlightDto> getAllByUserId(long userId) {
        return userFlightRepository.findAllByUserId(userId)
                .stream()
                .map(userFlightMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserFlightDto> getById(long id) {
        return userFlightRepository.findById(id)
                .map(userFlightMapper::entityToDto);
    }

    @Override
    public List<UserFlightDto> getAllByIds(List<Long> ids) {
        return userFlightRepository.findAllById(ids)
                .stream()
                .map(userFlightMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserFlightDto add(UserFlightDto userFlightDto) {
        return userFlightMapper.entityToDto(userFlightRepository.save(userFlightMapper.dtoToEntity(userFlightDto)));
    }

    @Override
    public UserFlightDto add(SingleFlightDto singleFlightDto, int seatNumber) {
        return userFlightMapper.entityToDto(userFlightRepository.save(userFlightMapper.dtoToEntity(UserFlightDto.builder()
                .seat(seatNumber)
                .singleFlight(singleFlightDto)
                .build())));
    }

    @Override
    public void delete(long id) {
        userFlightRepository.deleteById(id);
    }
}
