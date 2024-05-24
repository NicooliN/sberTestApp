package ru.sber.test.app.sbertestapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@MappedSuperclass
public class GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_generator")
    @Column(name = "id", nullable = false)
    private Long id;
}
