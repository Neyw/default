package ua.kharkov.khpi.vinokurov.diploma.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.UserRole;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String phone;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private UserRole role;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<PaymentInfoEntity> paymentInfo;
}
