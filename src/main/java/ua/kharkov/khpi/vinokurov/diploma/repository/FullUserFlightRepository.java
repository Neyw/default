package ua.kharkov.khpi.vinokurov.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.FullUserFlightEntity;

import java.util.List;


public interface FullUserFlightRepository extends PagingAndSortingRepository<FullUserFlightEntity, Long> {
    List<FullUserFlightEntity> getAllByUserId(long userId);
}
