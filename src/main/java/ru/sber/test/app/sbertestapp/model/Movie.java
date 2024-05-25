package ru.sber.test.app.sbertestapp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinTable(name = "orders_movies",
            joinColumns = @JoinColumn(name = "movie_id"), foreignKey = @ForeignKey(name = "FK_MOVIES_ORDERS"),
            inverseJoinColumns = @JoinColumn(name = "order_id"), inverseForeignKey = @ForeignKey(name = "FK_ORDERS_MOVIES"))

    private Set<Order> orders;
}
