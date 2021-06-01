package ua.kharkov.khpi.vinokurov.diploma.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
public enum PaymentType {
    CARD("card");
    private final String code;
    @Override
    public String toString() {
        return code;
    }
}
