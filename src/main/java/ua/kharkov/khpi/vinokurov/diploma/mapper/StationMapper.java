package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Mapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.StationDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.StationEntity;

@Mapper(componentModel = "spring")
public interface StationMapper extends EntityDtoMapper<StationEntity, StationDto> {
}
