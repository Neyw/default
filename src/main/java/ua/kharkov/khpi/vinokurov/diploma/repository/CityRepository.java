package ua.kharkov.khpi.vinokurov.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.CityEntity;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.CountryEntity;

import java.util.List;


public interface CityRepository extends PagingAndSortingRepository<CityEntity, Long> {
    List<CityEntity> findByCountry(CountryEntity countryEntity);

    @Override
    List<CityEntity> findAll();
}
