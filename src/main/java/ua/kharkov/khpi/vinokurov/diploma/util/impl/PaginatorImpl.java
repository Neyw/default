package ua.kharkov.khpi.vinokurov.diploma.util.impl;

import org.springframework.stereotype.Component;
import ua.kharkov.khpi.vinokurov.diploma.util.Paginator;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaginatorImpl implements Paginator {
    public <T> List<T> getPage(List<T> source, int page, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("wrong pagination settings");
        }

        int pageStart = page * size;
        if (pageStart > source.size() - 1 || pageStart < 0) {
            return new ArrayList<>();
        }

        if (size > source.size()) {
            size = source.size();
        }
        return new ArrayList<>(source.subList(pageStart, pageStart + size));
    }

    public <T> List<List<T>> toPages(List<T> source, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("wrong pagination settings");
        }
        List<List<T>> result = new ArrayList<>();
        if (size > source.size()) {
            result.add(source);
            return result;
        }

        int fullPageAmount = source.size() / size;
        int lastPageSize = source.size() % size;
        for (int k = 0; k < fullPageAmount; k++) {
            result.add(source.subList(k * size, k * (size + 1)));
        }
        result.add(source.subList(fullPageAmount * size, fullPageAmount * size + lastPageSize));

        return result;
    }

    @Override
    public <T> int getPageAmount(List<T> source, int size) {
        return source.size() % size == 0 ?
                source.size() / size
                : source.size() / size + 1;
    }
}
