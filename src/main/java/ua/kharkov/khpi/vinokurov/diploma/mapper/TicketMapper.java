package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Mapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.TicketDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.TicketEntity;

@Mapper(componentModel = "spring")
public interface TicketMapper extends EntityDtoMapper<TicketEntity, TicketDto> {
}
