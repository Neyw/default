package ua.kharkov.khpi.vinokurov.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.OrderStatus;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.PaymentType;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.CardDataDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.OrderDto;
import ua.kharkov.khpi.vinokurov.diploma.service.OrderService;
import ua.kharkov.khpi.vinokurov.diploma.service.PaymentInfoService;


@Controller
@RequestMapping("/checkout")
public class CheckoutController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private PaymentInfoService paymentInfoService;

    @PutMapping("/payment/orderId/{id}")
    public OrderDto setPaymentType(@PathVariable("id") long orderId, @ModelAttribute PaymentType paymentType) {
        return orderService.setPaymentType(orderId, paymentType)
                .orElseThrow(() -> new RuntimeException("no such id"));
    }

    @PutMapping("/card/orderId/{id}")
    public OrderDto setCardData(@PathVariable("id") long orderId, @ModelAttribute CardDataDto cardDataDto) {
        return orderService.setCard(orderId, cardDataDto)
                .orElseThrow(() -> new RuntimeException("no such id"));
    }

    @PutMapping("/pay/orderId/{id}")
    public OrderDto pay(@PathVariable("id") long orderId) {
        return orderService.updateOrderStatus(orderId, OrderStatus.PAYED)
                .orElseThrow(() -> new RuntimeException("no such id"));
    }
}
