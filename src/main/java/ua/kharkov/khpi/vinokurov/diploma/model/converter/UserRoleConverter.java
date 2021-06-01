package ua.kharkov.khpi.vinokurov.diploma.model.converter;

import ua.kharkov.khpi.vinokurov.diploma.model.enums.UserRole;

import javax.persistence.Converter;
import java.util.Optional;

@Converter(autoApply = true)
public class UserRoleConverter extends StringEnumConverter<UserRole> {
    @Override
    public UserRole convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData)
                .map(UserRole::valueOf)
                .orElse(null);
    }
}
