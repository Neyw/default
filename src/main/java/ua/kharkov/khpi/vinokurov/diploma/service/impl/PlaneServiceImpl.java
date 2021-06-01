package ua.kharkov.khpi.vinokurov.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.khpi.vinokurov.diploma.mapper.PlaneMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.PlaneDto;
import ua.kharkov.khpi.vinokurov.diploma.repository.PlaneRepository;
import ua.kharkov.khpi.vinokurov.diploma.service.PlaneService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaneServiceImpl implements PlaneService {
    @Autowired
    private PlaneRepository planeRepository;
    @Autowired
    private PlaneMapper planeMapper;

    @Override
    public Optional<PlaneDto> getById(long id) {
        return planeRepository.findById(id)
                .map(planeMapper::entityToDto);
    }

    @Override
    public List<PlaneDto> getAll() {
        return planeRepository.findAll()
                .stream()
                .map(planeMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PlaneDto create(PlaneDto routeDto) {
        return planeMapper.entityToDto(planeRepository.save(planeMapper.dtoToEntity(routeDto)));
    }

    @Override
    public Optional<PlaneDto> updateName(long planeId, String newName) {
        final Optional<PlaneDto> planeDto = getById(planeId);
        planeDto.ifPresent(plane -> plane.setName(newName));
        return planeDto.map(planeMapper::dtoToEntity)
                .map(planeRepository::save)
                .map(planeMapper::entityToDto);
    }

    @Override
    public void delete(long id) {
        planeRepository.deleteById(id);
    }
}
