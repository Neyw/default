package ua.kharkov.khpi.vinokurov.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.PaymentInfoEntity;


public interface PaymentInfoRepository extends PagingAndSortingRepository<PaymentInfoEntity, Long> {
}
