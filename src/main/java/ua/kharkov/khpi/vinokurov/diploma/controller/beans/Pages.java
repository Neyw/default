package ua.kharkov.khpi.vinokurov.diploma.controller.beans;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.Objects;
import java.util.Set;

@Builder
@Data
public class Pages {
    @Singular
    private Set<PageData> pageDatas;

    public PageData getPageByName(String name) {
        return pageDatas.stream()
                .filter(pageData -> Objects.equals(pageData.getName(), name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No page for such a name"));
    }
}
