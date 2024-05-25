package ru.sber.test.app.sbertestapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sber.test.app.sbertestapp.dto.GenericDTO;
import ru.sber.test.app.sbertestapp.model.GenericModel;
import ru.sber.test.app.sbertestapp.service.GenericService;

import java.util.List;

@Slf4j
@RestController
public abstract class GenericController<T extends GenericModel, D extends GenericDTO> {

    private final GenericService<T, D> genericService;


    public GenericController(GenericService<T, D> genericService) {
        this.genericService = genericService;
    }


    @Operation(description = "Получить информацию о всех объектах по ID", method = "listAll")
    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<D>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(genericService.listAll());
    }


    @Operation(description = "Получить информацию о объекте по ID", method = "getById")
    @GetMapping(value = "/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> getEntityById(@RequestParam(value = "id") Long id) {
        log.error("djn");
        return ResponseEntity.status(HttpStatus.OK).body(genericService.getOne(id));
    }

    @Operation(description = "Добавить объект в таблицу", method = "create")
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> create(@RequestBody D newEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(genericService.create(newEntity));
    }

    @Operation(description = "Обновить объект в таблице", method = "update")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> update(@RequestBody D updateEntity,
                                        @RequestParam(value = "id") Long id) {
        updateEntity.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericService.update(updateEntity));
    }

    @Operation(description = "Удалить объект из таблицы", method = "delete")
    @PutMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestParam(value = "id") Long id) {
        genericService.delete(id);
    }


}
