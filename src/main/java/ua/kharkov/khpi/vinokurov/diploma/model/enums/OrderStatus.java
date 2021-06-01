package ua.kharkov.khpi.vinokurov.diploma.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    NEW("new"), PAYED("payed"), COMPLETED("completed"), EXPIRED("expired");
    private final String code;
    @Override
    public String toString() {
        return code;
    }
}
