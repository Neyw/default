package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.CardDataDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.CardDataEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CardDataMapper extends EntityDtoMapper<CardDataEntity, CardDataDto> {
}
