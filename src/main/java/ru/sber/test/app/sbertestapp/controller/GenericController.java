package ru.sber.test.app.sbertestapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;
import ru.sber.test.app.sbertestapp.model.GenericModel;
import ru.sber.test.app.sbertestapp.repository.GenericRepository;


@RestController
public abstract class GenericController<T extends GenericModel> {

    private final GenericRepository<T> genericRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public GenericController(GenericRepository<T> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Operation(description = "Получить информацию о объекте по ID", method = "getById")
    @GetMapping(value = "/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> getEntityById(@RequestParam(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(genericRepository.findById(id).orElseThrow(() -> new NotFoundException("Нету данных по этому id: " + id)));
    }

    @Operation(description = "Добавить объект в таблицу", method = "create")
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> create(@RequestBody T newEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(genericRepository.save(newEntity));
    }

    @Operation(description = "Обновить объект в таблице", method = "update")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> update(@RequestBody T updateEntity,
                                        @RequestParam(value = "id") Long id) {
        updateEntity.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericRepository.save(updateEntity));
    }

    @Operation(description = "Удалить объект из таблицы", method = "delete")
    @PutMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestParam(value = "id") Long id) {
        genericRepository.deleteById(id);
    }
}
