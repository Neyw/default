package ua.kharkov.khpi.vinokurov.diploma.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;

@Data
@NoArgsConstructor
@Entity(name = "route")
public class RouteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "start_station_id")
    private StationEntity startStation;
    @ManyToOne
    @JoinColumn(name = "end_station_id")
    private StationEntity endStation;
    private Time startTime;
    private Time endTime;
}
