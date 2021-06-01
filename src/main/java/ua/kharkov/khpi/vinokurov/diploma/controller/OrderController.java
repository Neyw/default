package ua.kharkov.khpi.vinokurov.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.kharkov.khpi.vinokurov.diploma.model.enums.OrderStatus;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.OrderDto;
import ua.kharkov.khpi.vinokurov.diploma.service.OrderService;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/get/{id}")
    public Optional<OrderDto> getOrder(@PathVariable("id") long id, Model model) {
        return orderService.getOrder(id);
    }

    @PostMapping("/create")
    @ResponseBody
    public OrderDto createOrder(@ModelAttribute OrderDto order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/update/orderId/{id}")
    @ResponseBody
    public Optional<OrderDto> updateOrderStatus(@PathVariable("id") long orderId, @ModelAttribute OrderStatus status) {
        return orderService.updateOrderStatus(orderId, status);
    }

    @GetMapping("/get/userId/{id}")
    public List<OrderDto> getUserOrders(@PathVariable("id") long userId, Model model) {
        return orderService.getOrdersByUser(userId);
    }
}
