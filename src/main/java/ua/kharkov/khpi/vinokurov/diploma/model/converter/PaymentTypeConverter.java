package ua.kharkov.khpi.vinokurov.diploma.model.converter;

import ua.kharkov.khpi.vinokurov.diploma.model.enums.PaymentType;

import javax.persistence.Converter;
import java.util.Optional;

@Converter(autoApply = true)
public class PaymentTypeConverter extends StringEnumConverter<PaymentType> {
    @Override
    public PaymentType convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData)
                .map(PaymentType::valueOf)
                .orElse(null);
    }
}
