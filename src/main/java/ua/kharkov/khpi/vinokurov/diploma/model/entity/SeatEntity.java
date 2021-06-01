package ua.kharkov.khpi.vinokurov.diploma.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.SeatType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity(name = "seat")
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int number;
    @Enumerated(value = EnumType.STRING)
    private SeatType type;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "basket_id")
    private BasketEntity basket;
    @ManyToOne
    @JoinColumn(name = "single_flight_id")
    private SingleFlightEntity singleFlight;
}
