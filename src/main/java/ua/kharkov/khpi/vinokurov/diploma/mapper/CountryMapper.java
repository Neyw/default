package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.CountryDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.CountryEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CountryMapper extends EntityDtoMapper<CountryEntity, CountryDto> {
}
