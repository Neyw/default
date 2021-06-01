package ua.kharkov.khpi.vinokurov.diploma.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.UserRole;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto implements Serializable {
    private long id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String phone;
    private String password;
    private UserRole role;
    private List<PaymentInfoDto> paymentInfo;
}
