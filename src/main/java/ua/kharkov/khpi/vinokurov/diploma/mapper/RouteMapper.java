package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Mapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.RouteDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.RouteEntity;

@Mapper(componentModel = "spring")
public interface RouteMapper extends EntityDtoMapper<RouteEntity, RouteDto> {

}
