package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.BasketDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SeatDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.BasketEntity;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.SeatEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class BasketMapper implements EntityDtoMapper<BasketEntity, BasketDto> {
    @Override
    @Mapping(source = "user.password", target = "user.password", qualifiedByName = ERASE_PASSWORD)
    public abstract BasketDto entityToDto(BasketEntity entity);

    @Autowired
    private SeatMapper seatMapper;
}
