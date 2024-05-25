package ru.sber.test.app.sbertestapp.repository;

import org.springframework.stereotype.Repository;
import ru.sber.test.app.sbertestapp.model.Movie;

@Repository
public interface MovieRepository
        extends GenericRepository<Movie> {
}
