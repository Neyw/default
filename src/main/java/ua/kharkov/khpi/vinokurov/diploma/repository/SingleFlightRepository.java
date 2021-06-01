package ua.kharkov.khpi.vinokurov.diploma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.RouteEntity;
import ua.kharkov.khpi.vinokurov.diploma.model.entity.SingleFlightEntity;

import java.sql.Date;
import java.util.List;


public interface SingleFlightRepository extends PagingAndSortingRepository<SingleFlightEntity, Long> {
    List<SingleFlightEntity> findAllByRoute(RouteEntity route);

    List<SingleFlightEntity> findByDateAndRouteIdIn(Date beginDate, List<Long> routeIds);


    @Override
    List<SingleFlightEntity> findAll();
}
