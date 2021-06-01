package ua.kharkov.khpi.vinokurov.diploma.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SeatType {
    FIRST_CLASS("first"), SECOND_CLASS("second"), BUSINESS_CLASS("business");
    private final String code;

    @Override
    public String toString() {
        return code;
    }
}
