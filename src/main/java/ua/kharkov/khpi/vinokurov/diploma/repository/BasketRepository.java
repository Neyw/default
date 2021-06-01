package ua.kharkov.khpi.vinokurov.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.BasketEntity;

import java.util.Optional;


public interface BasketRepository extends PagingAndSortingRepository<BasketEntity, Long> {
    Optional<BasketEntity> findByUserId(long userId);

    boolean existsByUserId(long userId);
}
