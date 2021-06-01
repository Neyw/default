package ua.kharkov.khpi.vinokurov.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.TicketEntity;


public interface TicketRepository extends PagingAndSortingRepository<TicketEntity, Long> {
}
