package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.UserEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper extends EntityDtoMapper<UserEntity, UserDto> {
    @Override
    @Mapping(target = "password", defaultValue = "")
    UserDto entityToDto(UserEntity entity);

    UserDto entityToDtoWithPassword(UserEntity entity);
}
