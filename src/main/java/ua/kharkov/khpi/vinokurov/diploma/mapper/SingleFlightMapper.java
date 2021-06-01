package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SeatDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SingleFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.SeatEntity;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.SingleFlightEntity;

@Mapper(componentModel = "spring")
public abstract class SingleFlightMapper implements EntityDtoMapper<SingleFlightEntity, SingleFlightDto> {
    @Autowired
    private SeatMapper seatMapper;
}
