package ua.kharkov.khpi.vinokurov.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.UserFlightEntity;

import java.util.List;


public interface UserFlightRepository extends PagingAndSortingRepository<UserFlightEntity, Long> {
    List<UserFlightEntity> findAllByUserId(long userId);

    @Override
    List<UserFlightEntity> findAllById(Iterable<Long> ids);
}
