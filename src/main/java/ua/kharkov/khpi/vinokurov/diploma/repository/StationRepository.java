package ua.kharkov.khpi.vinokurov.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.CityEntity;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.StationEntity;

import java.util.List;


public interface StationRepository extends PagingAndSortingRepository<StationEntity, Long> {
    List<StationEntity> findByCity(CityEntity cityEntity);


    @Override
    List<StationEntity> findAll();
}
