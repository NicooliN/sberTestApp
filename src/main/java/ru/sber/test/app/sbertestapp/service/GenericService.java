package ru.sber.test.app.sbertestapp.service;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.sber.test.app.sbertestapp.dto.GenericDTO;
import ru.sber.test.app.sbertestapp.mapper.GenericMapper;
import ru.sber.test.app.sbertestapp.model.GenericModel;
import ru.sber.test.app.sbertestapp.repository.GenericRepository;

import java.util.List;

@Service
public abstract class GenericService <T extends GenericModel, D extends GenericDTO> {

 private final GenericRepository<T> genericRepository;

 private final GenericMapper<T, D> genericMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
 protected GenericService(GenericRepository<T> genericRepository,
                          GenericMapper<T, D> genericMapper) {
     this.genericMapper = genericMapper;
     this.genericRepository = genericRepository;
 }

 public List<D> listAll() {
     return genericMapper.toDTOs(genericRepository.findAll());
 }

 public D getOne(Long id) {
     return genericMapper.toDTO(genericRepository.findById(id).orElseThrow(() -> new NotFoundException("нет дфнных по такому id: " + id)));
 }

 public D create(D newDTO) {
     return genericMapper.toDTO(genericRepository.save(genericMapper.toEntity(newDTO)));
 }

    public D update(D updateDTO) {
        return genericMapper.toDTO(genericRepository.save(genericMapper.toEntity(updateDTO)));
    }

    public void delete(Long id) {
     genericRepository.deleteById(id);
    }
}
