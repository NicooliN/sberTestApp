package ru.sber.test.app.sbertestapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.sber.test.app.sbertestapp.dto.MovieDTO;
import ru.sber.test.app.sbertestapp.model.Movie;
import ru.sber.test.app.sbertestapp.service.MovieService;

@Slf4j
@RestController
@RequestMapping(value ="/movies")
@Tag(name = "Фильмы", description = "Контроллер для работы с фильмами")
public class MovieController extends GenericController<Movie, MovieDTO>{


    public MovieController(MovieService movieService) {
        super(movieService);
    }

//    @Operation(description = "Добавить заказ к фильму", method = "addOrder")
//    @PostMapping(value = "/addOrder", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Movie> addOrder(@RequestParam(value = "movieId") Long movieId,
//                                          @RequestParam(value = "orderId") Long orderId) {
//        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new NotFoundException("фильм не найден"));
//        Order order = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("заказ не найден"));
//        movie.getOrders().add(order);
//        return ResponseEntity.status(HttpStatus.CREATED).body(movieRepository.save(movie));
//    }
}
