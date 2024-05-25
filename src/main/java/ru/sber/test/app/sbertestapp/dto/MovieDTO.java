package ru.sber.test.app.sbertestapp.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sber.test.app.sbertestapp.model.Genre;
import ru.sber.test.app.sbertestapp.model.Order;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class MovieDTO extends GenericDTO {

    private String title;

    private String premierYear;

    private String country;

    private Genre genre;

    private Set<Long> orderIds;
}
