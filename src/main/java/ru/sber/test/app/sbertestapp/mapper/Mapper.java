package ru.sber.test.app.sbertestapp.mapper;

import ru.sber.test.app.sbertestapp.dto.GenericDTO;
import ru.sber.test.app.sbertestapp.model.GenericModel;

import java.util.List;

public interface Mapper <E extends GenericModel, D extends GenericDTO> {
    E toEntity(D dto);

    D toDTO(E entity);

    List<E> toEntities(List<D> DTOs);

    List<D> toDTOs(List<E> entities);
}
