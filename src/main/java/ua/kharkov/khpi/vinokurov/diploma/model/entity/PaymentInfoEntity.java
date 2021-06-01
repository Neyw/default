package ua.kharkov.khpi.vinokurov.diploma.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.PaymentType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@Entity(name = "payment_info")
public class PaymentInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType;
    @OneToOne
    @JoinColumn(name = "card_data_id")
    private CardDataEntity cardData;
}
