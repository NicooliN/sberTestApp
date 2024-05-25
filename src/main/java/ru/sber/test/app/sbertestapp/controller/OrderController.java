package ru.sber.test.app.sbertestapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sber.test.app.sbertestapp.dto.OrderDTO;
import ru.sber.test.app.sbertestapp.model.Order;
import ru.sber.test.app.sbertestapp.service.OrderService;

@Slf4j
@RestController
@RequestMapping(value ="/orders")
@Tag(name = "Заказ", description = "Контроллер для работы с заказами")
public class OrderController extends GenericController<Order, OrderDTO> {

    public OrderController(OrderService orderService) {
        super(orderService);
    }

//    @Operation(description = "Добавить фильм в заказ", method = "addMovie")
//    @PostMapping(value = "/addMovie", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Order> addMovie(@RequestParam(value = "movieId") Long movieId,
//                                          @RequestParam(value = "orderId") Long orderId) {
//        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new NotFoundException("фильм не найден"));
//        Order order = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("заказ не найден"));
//        order.getMovies().add(movie);
//        return ResponseEntity.status(HttpStatus.CREATED).body(orderRepository.save(order));
//    }
}