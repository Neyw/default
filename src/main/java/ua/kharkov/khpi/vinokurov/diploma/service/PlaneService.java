package ua.kharkov.khpi.vinokurov.diploma.service;

import ua.kharkov.khpi.vinokurov.diploma.model.dto.PlaneDto;

import java.util.List;
import java.util.Optional;

public interface PlaneService {

    Optional<PlaneDto> getById(long id);

    List<PlaneDto> getAll();

    PlaneDto create(PlaneDto routeDto);

    Optional<PlaneDto> updateName(long planeId, String newName);

    void delete(long id);
}
