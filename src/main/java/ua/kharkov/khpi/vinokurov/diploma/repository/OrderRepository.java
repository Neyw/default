package ua.kharkov.khpi.vinokurov.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.OrderEntity;

import java.util.List;


public interface OrderRepository extends PagingAndSortingRepository<OrderEntity, Long> {
    List<OrderEntity> findAllByUserId(long userId);
}
