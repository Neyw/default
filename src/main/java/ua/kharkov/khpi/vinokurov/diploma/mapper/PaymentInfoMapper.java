package ua.kharkov.khpi.vinokurov.diploma.mapper;

import org.mapstruct.Mapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.PaymentInfoDto;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.PaymentInfoEntity;

@Mapper(componentModel = "spring")
public interface PaymentInfoMapper extends EntityDtoMapper<PaymentInfoEntity, PaymentInfoDto> {
}
