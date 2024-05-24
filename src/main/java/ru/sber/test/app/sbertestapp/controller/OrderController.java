package ru.sber.test.app.sbertestapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;
import ru.sber.test.app.sbertestapp.model.Order;
import ru.sber.test.app.sbertestapp.repository.OrderRepository;

@RestController
@RequestMapping(value ="/orders")
@Tag(name = "Заказ", description = "Контроллер для работы с заказами")
public class OrderController extends GenericController<Order> {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        super(orderRepository);
        this.orderRepository = orderRepository;
    }

}