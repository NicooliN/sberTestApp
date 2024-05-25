package ru.sber.test.app.sbertestapp.mapper;

import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.sber.test.app.sbertestapp.dto.MovieDTO;
import ru.sber.test.app.sbertestapp.dto.OrderDTO;
import ru.sber.test.app.sbertestapp.model.GenericModel;
import ru.sber.test.app.sbertestapp.model.Movie;
import ru.sber.test.app.sbertestapp.model.Order;
import ru.sber.test.app.sbertestapp.repository.MovieRepository;
import ru.sber.test.app.sbertestapp.repository.OrderRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderMapper extends GenericMapper<Order, OrderDTO> {

    private final MovieRepository movieRepository;
    protected OrderMapper(ModelMapper modelMapper, MovieRepository movieRepository) {
        super(modelMapper, Order.class, OrderDTO.class);
        this.movieRepository = movieRepository;
    }


    @PostConstruct
    public void setupMapper(){
        modelMapper.createTypeMap(Order.class, OrderDTO.class).addMappings(m -> m.skip(OrderDTO::setMovieIds)).setPostConverter(toDTOconverter());
        modelMapper.createTypeMap(OrderDTO.class, Order.class).addMappings(m ->m.skip(Order::setMovies)).setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(OrderDTO source, Order destination){
        if(!Objects.isNull(source.getMovieIds())) {
            destination.setMovies(new HashSet<>(movieRepository.findAllById(source.getMovieIds())));
        } else {
            destination.setMovies(Collections.emptySet());
        }
    }


    @Override
    protected void mapSpecificFields(Order source, OrderDTO destination){
        destination.setMovieIds(getIds(source));
    }

    Set<Long> getIds(Order order){
        return Objects.isNull(order) || Objects.isNull(order.getMovies())
                ? Collections.emptySet()
                : order.getMovies().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toSet());
    }

}



