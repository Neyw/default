package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Mapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.PlaneDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.PlaneEntity;

@Mapper(componentModel = "spring")
public interface PlaneMapper extends EntityDtoMapper<PlaneEntity, PlaneDto> {
}
