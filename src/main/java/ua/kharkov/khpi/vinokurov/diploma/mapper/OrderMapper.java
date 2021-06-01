package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.OrderDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.OrderEntity;

@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityDtoMapper<OrderEntity, OrderDto> {
    @Override
    @Mapping(source = "user.password", target = "user.password", qualifiedByName = ERASE_PASSWORD)
    OrderDto entityToDto(OrderEntity entity);
}
