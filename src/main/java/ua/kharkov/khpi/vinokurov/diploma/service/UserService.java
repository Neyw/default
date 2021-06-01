package ua.kharkov.khpi.vinokurov.diploma.service;

import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserDto> findByUsername(String username);

    List<UserDto> getAll();

    Optional<UserDto> getById(long id);

    UserDto add(UserDto userEntity);

    void delete(long id);

    UserDto update(UserDto userEntity);
}
