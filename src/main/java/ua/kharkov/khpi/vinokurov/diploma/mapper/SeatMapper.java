package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.BasketDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SeatDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SingleFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.BasketEntity;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.SeatEntity;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.SingleFlightEntity;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class SeatMapper implements EntityDtoMapper<SeatEntity, SeatDto> {
    @Autowired
    private BasketMapper basketMapper;
    @Autowired
    private SingleFlightMapper singleFlightMapper;

    @Override
    @Mapping(source = "user.password", target = "user.password", qualifiedByName = ERASE_PASSWORD)
    public abstract SeatDto entityToDto(SeatEntity entity);
}
