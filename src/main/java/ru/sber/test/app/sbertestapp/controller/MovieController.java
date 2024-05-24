package ru.sber.test.app.sbertestapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;
import ru.sber.test.app.sbertestapp.model.Movie;
import ru.sber.test.app.sbertestapp.repository.MovieRepository;

@RestController
@RequestMapping(value ="/movies")
@Tag(name = "Фильмы", description = "Контроллер для работы с фильмами")
public class MovieController extends GenericController<Movie>{

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        super(movieRepository);
        this.movieRepository = movieRepository;
    }

}
