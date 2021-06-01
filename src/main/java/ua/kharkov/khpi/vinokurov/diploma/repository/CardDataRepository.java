package ua.kharkov.khpi.vinokurov.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.CardDataEntity;


public interface CardDataRepository extends PagingAndSortingRepository<CardDataEntity, Long> {
}
