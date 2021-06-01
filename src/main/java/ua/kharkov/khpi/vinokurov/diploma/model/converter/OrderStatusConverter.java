package ua.kharkov.khpi.vinokurov.diploma.model.converter;

import ua.kharkov.khpi.vinokurov.diploma.model.enums.OrderStatus;

import javax.persistence.Converter;
import java.util.Optional;

@Converter(autoApply = true)
public class OrderStatusConverter extends StringEnumConverter<OrderStatus> {
    @Override
    public OrderStatus convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData)
                .map(OrderStatus::valueOf)
                .orElse(null);
    }
}
