package ru.sber.test.app.sbertestapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "movies")
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "movies_gen", sequenceName = "movies_seq", allocationSize = 1)
public class Movie extends GenericModel{

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "premier_year", nullable = false)
    private String premierYear;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "genre", nullable = false)
    @Enumerated
    private Genre genre;

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Order> orders;
}
