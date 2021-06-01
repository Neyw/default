package ua.kharkov.khpi.vinokurov.diploma.service;

import ua.kharkov.khpi.vinokurov.diploma.model.dto.PaymentInfoDto;

import java.util.Optional;


public interface PaymentInfoService {
    Optional<PaymentInfoDto> getPaymentInfo(long id);

    PaymentInfoDto createPaymentInfo(PaymentInfoDto order);

    void deletePaymentInfo(long id);
}
