package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.CityDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.CityEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CityMapper extends EntityDtoMapper<CityEntity, CityDto> {
}
