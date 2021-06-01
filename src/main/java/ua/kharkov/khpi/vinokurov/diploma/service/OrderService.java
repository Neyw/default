package ua.kharkov.khpi.vinokurov.diploma.service;

import ua.kharkov.khpi.vinokurov.diploma.model.enums.OrderStatus;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.PaymentType;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.CardDataDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.OrderDto;

import java.util.List;
import java.util.Optional;


public interface OrderService {
    Optional<OrderDto> setPaymentType(long orderId, PaymentType paymentType);

    Optional<OrderDto> setCard(long orderId, CardDataDto cardData);

    Optional<OrderDto> getOrder(long id);

    List<OrderDto> getOrdersByUser(long userId);

    OrderDto createOrder(OrderDto order);

    Optional<OrderDto> updateOrderStatus(long orderId, OrderStatus orderStatus);

    void deleteOrder(long orderId);
}
