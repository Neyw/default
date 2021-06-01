package ua.kharkov.khpi.vinokurov.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.CountryEntity;

import java.util.List;


public interface CountryRepository extends PagingAndSortingRepository<CountryEntity, Long> {
    @Override
    List<CountryEntity> findAll();
}
