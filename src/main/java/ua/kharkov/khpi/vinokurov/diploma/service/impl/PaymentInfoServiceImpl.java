package ua.kharkov.khpi.vinokurov.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.khpi.vinokurov.diploma.mapper.PaymentInfoMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.PaymentInfoDto;
import ua.kharkov.khpi.vinokurov.diploma.repository.PaymentInfoRepository;
import ua.kharkov.khpi.vinokurov.diploma.service.PaymentInfoService;

import java.util.Optional;

@Service
public class PaymentInfoServiceImpl implements PaymentInfoService {
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;
    @Autowired
    private PaymentInfoMapper paymentInfoMapper;

    @Override
    public Optional<PaymentInfoDto> getPaymentInfo(long id) {
        return paymentInfoRepository.findById(id)
                .map(paymentInfoMapper::entityToDto);
    }

    @Override
    public PaymentInfoDto createPaymentInfo(PaymentInfoDto order) {
        return paymentInfoMapper.entityToDto(paymentInfoRepository.save(paymentInfoMapper.dtoToEntity(order)));
    }

    @Override
    public void deletePaymentInfo(long id) {
        paymentInfoRepository.deleteById(id);
    }
}
