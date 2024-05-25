package ru.sber.test.app.sbertestapp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "orders")
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "orders_gen", sequenceName = "orders_seq", allocationSize = 1)
public class Order extends GenericModel{

    @Column(name = "order_number", nullable = false)
    private String orderNumber;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "orders_movies",
            joinColumns = @JoinColumn(name = "order_id"), foreignKey = @ForeignKey(name = "FK_ORDERS_MOVIES"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"), inverseForeignKey = @ForeignKey(name = "FK_MOVIES_ORDERS"))
    private Set<Movie> movies;
}
