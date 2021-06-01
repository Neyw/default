package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Mapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.FullUserFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.FullUserFlightEntity;

@Mapper(componentModel = "spring")
public interface FullUserFlightMapper extends EntityDtoMapper<FullUserFlightEntity, FullUserFlightDto> {
}
