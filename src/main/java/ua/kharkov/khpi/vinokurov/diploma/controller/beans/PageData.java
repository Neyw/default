package ua.kharkov.khpi.vinokurov.diploma.controller.beans;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PageData {
    @EqualsAndHashCode.Include
    private final String name;
    private final String address;
}
