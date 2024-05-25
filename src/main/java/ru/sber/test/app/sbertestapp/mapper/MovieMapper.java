package ru.sber.test.app.sbertestapp.mapper;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.sber.test.app.sbertestapp.dto.MovieDTO;
import ru.sber.test.app.sbertestapp.model.GenericModel;
import ru.sber.test.app.sbertestapp.model.Movie;
import ru.sber.test.app.sbertestapp.repository.OrderRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MovieMapper
        extends GenericMapper<Movie, MovieDTO> {

    private final OrderRepository orderRepository;

    protected MovieMapper(ModelMapper modelMapper,
                          OrderRepository orderRepository) {
        super(modelMapper, Movie.class, MovieDTO.class);
        this.orderRepository = orderRepository;
    }

    @PostConstruct
    public void setupMapper(){
        modelMapper.createTypeMap(Movie.class, MovieDTO.class).addMappings(m -> m.skip(MovieDTO::setOrderIds)).setPostConverter(toDTOconverter());
        modelMapper.createTypeMap(MovieDTO.class, Movie.class).addMappings(m ->m.skip(Movie::setOrders)).setPostConverter(toEntityConverter());
    }

@Override
    protected void mapSpecificFields(MovieDTO source, Movie destination){
    if(!Objects.isNull(source.getOrderIds())) {
        destination.setOrders(new HashSet<>(orderRepository.findAllById(source.getOrderIds())));
    } else {
        destination.setOrders(Collections.emptySet());
    }
}


    @Override
    protected void mapSpecificFields(Movie source, MovieDTO destination){
        destination.setOrderIds(getIds(source));
    }

    Set<Long> getIds(Movie movie){
        return Objects.isNull(movie) || Objects.isNull(movie.getOrders())
                ? Collections.emptySet()
                : movie.getOrders().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toSet());
    }

}
