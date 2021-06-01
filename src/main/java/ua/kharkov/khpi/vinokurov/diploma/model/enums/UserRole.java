package ua.kharkov.khpi.vinokurov.diploma.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {
    CUSTOMER("customer"), ADMIN("admin");
    private final String code;

    @Override
    public String toString() {
        return code;
    }
}
