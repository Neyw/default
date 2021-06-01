package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.kharkov.khpi.vinokurov.diploma.mapper.impl.TimeMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.UserFlightEntity;

@Mapper(componentModel = "spring", uses = TimeMapper.class)
public interface UserFlightMapper extends EntityDtoMapper<UserFlightEntity, UserFlightDto> {
    @Override
    @Mapping(source = "user.password", target = "user.password", qualifiedByName = ERASE_PASSWORD)
    UserFlightDto entityToDto(UserFlightEntity entity);
}
