package ua.kharkov.khpi.vinokurov.diploma.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "single_flight")
public class SingleFlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "route_id")
    private RouteEntity route;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "plane_id")
    private PlaneEntity plane;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "single_flight_id")
    private List<SeatEntity> seat;
}
