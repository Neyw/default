package ua.kharkov.khpi.vinokurov.diploma.util;

import java.util.List;

public interface Paginator {
    <T> List<T> getPage(List<T> source, int page, int size);

    <T> List<List<T>> toPages(List<T> source, int size);

    <T> int getPageAmount(List<T> source, int size);
}
