package ru.sber.test.app.sbertestapp.mapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.sber.test.app.sbertestapp.dto.GenericDTO;
import ru.sber.test.app.sbertestapp.model.GenericModel;

import java.util.List;
import java.util.Objects;

@Component
public abstract class GenericMapper<E extends GenericModel, D extends GenericDTO>
        implements Mapper<E, D> {

    protected final ModelMapper modelMapper;

    private final Class<D> dtoClass;

    private final Class<E> entityClass;

    protected GenericMapper(ModelMapper modelMapper,
                            Class<E> entityClass,
                            Class<D> dtoClass) {
        this.modelMapper = modelMapper;
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
    }

    @Override
    public E toEntity(D dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, entityClass);
    }

    @Override
    public D toDTO(E entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, dtoClass);
    }

    @Override
    public List<E> toEntities(List<D> dtos) {
        return dtos.stream().map(this::toEntity).toList();
    }
    @Override
    public List<D> toDTOs(List<E> entitys) {
        return entitys.stream().map(this::toDTO).toList();
    }

    Converter<E, D> toDTOconverter() {
        return contex -> {
            E source = contex.getSource();
            D destination = contex.getDestination();
            mapSpecificFields(source, destination);
            return contex.getDestination();
        };
    }

    Converter<D, E> toEntityConverter() {
        return contex -> {
            D source = contex.getSource();
            E destination = contex.getDestination();
            mapSpecificFields(source, destination);
            return contex.getDestination();
        };
    }

    protected abstract void mapSpecificFields(E source, D destination);
    protected abstract void mapSpecificFields(D source, E destination);

}
