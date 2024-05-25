package ru.sber.test.app.sbertestapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sber.test.app.sbertestapp.dto.MovieDTO;
import ru.sber.test.app.sbertestapp.mapper.MovieMapper;
import ru.sber.test.app.sbertestapp.model.Movie;
import ru.sber.test.app.sbertestapp.repository.MovieRepository;

@Slf4j
@Service
public class MovieService extends GenericService<Movie, MovieDTO> {

private final MovieRepository repository;

    protected MovieService(MovieRepository repository,
                        MovieMapper movieMapper) {
        super(repository, movieMapper);
        this.repository = repository;
    }

}
