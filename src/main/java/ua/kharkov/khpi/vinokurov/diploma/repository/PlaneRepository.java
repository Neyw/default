package ua.kharkov.khpi.vinokurov.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.PlaneEntity;

import java.util.List;


public interface PlaneRepository extends PagingAndSortingRepository<PlaneEntity, Long> {
    @Override
    List<PlaneEntity> findAll();
}
