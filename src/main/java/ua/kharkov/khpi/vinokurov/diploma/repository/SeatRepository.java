package ua.kharkov.khpi.vinokurov.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.BasketEntity;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.SeatEntity;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.UserEntity;

import java.util.List;


public interface SeatRepository extends PagingAndSortingRepository<SeatEntity, Long> {
    @Override
    List<SeatEntity> findAll();

    List<SeatEntity> findAllByUser(UserEntity userEntity);
}
