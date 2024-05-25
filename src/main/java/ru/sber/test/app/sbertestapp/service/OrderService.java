package ru.sber.test.app.sbertestapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sber.test.app.sbertestapp.dto.OrderDTO;
import ru.sber.test.app.sbertestapp.mapper.OrderMapper;
import ru.sber.test.app.sbertestapp.model.Order;
import ru.sber.test.app.sbertestapp.repository.OrderRepository;

@Slf4j
@Service
public class OrderService extends GenericService<Order, OrderDTO> {

    private final OrderRepository orderRepository;
    protected OrderService(OrderRepository orderRepository,
                           OrderMapper orderMapper) {
        super(orderRepository, orderMapper);
        this.orderRepository = orderRepository;
    }

}
