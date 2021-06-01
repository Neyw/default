package ua.kharkov.khpi.vinokurov.diploma.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserAccessLevel {
    ADMIN("admin"), CUSTOMER("customer");
    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
