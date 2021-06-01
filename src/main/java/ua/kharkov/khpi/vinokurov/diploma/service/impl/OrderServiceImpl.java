package ua.kharkov.khpi.vinokurov.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.khpi.vinokurov.diploma.mapper.OrderMapper;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.OrderStatus;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.PaymentType;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.CardDataDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.OrderDto;
import ua.kharkov.khpi.vinokurov.diploma.repository.OrderRepository;
import ua.kharkov.khpi.vinokurov.diploma.service.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Optional<OrderDto> setPaymentType(long orderId, PaymentType paymentType) {
        final Optional<OrderDto> order = orderRepository.findById(orderId)
                .map(orderMapper::entityToDto);
        order.ifPresent(orderDto -> orderDto.getPaymentInfo().setPaymentType(paymentType));
        return order.map(orderMapper::dtoToEntity)
                .map(orderRepository::save)
                .map(orderMapper::entityToDto);
    }

    @Override
    public Optional<OrderDto> setCard(long orderId, CardDataDto cardData) {
        final Optional<OrderDto> order = orderRepository.findById(orderId)
                .map(orderMapper::entityToDto);
        order.ifPresent(orderDto -> orderDto.getPaymentInfo().setCardData(cardData));
        return order.map(orderMapper::dtoToEntity)
                .map(orderRepository::save)
                .map(orderMapper::entityToDto);
    }

    @Override
    public Optional<OrderDto> getOrder(long id) {
        return orderRepository.findById(id)
                .map(orderMapper::entityToDto);
    }

    @Override
    public List<OrderDto> getOrdersByUser(long userId) {
        return orderRepository.findAllByUserId(userId)
                .stream()
                .map(orderMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto createOrder(OrderDto order) {
        order.setOrderStatus(OrderStatus.NEW);
        return orderMapper.entityToDto(orderRepository.save(orderMapper.dtoToEntity(order)));
    }

    @Override
    public Optional<OrderDto> updateOrderStatus(long orderId, OrderStatus orderStatus) {
        final Optional<OrderDto> order = getOrder(orderId);
        order.ifPresent(orderDto -> orderDto.setOrderStatus(orderStatus));
        return order.map(orderMapper::dtoToEntity)
                .map(orderRepository::save)
                .map(orderMapper::entityToDto);
    }

    @Override
    public void deleteOrder(long orderId) {
        orderRepository.deleteById(orderId);
    }
}
