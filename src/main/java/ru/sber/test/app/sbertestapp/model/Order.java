package ru.sber.test.app.sbertestapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "orders_gen", sequenceName = "orders_seq", allocationSize = 1)
public class Order extends GenericModel{

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "movie_id", foreignKey = @ForeignKey(name = "FK_ORDERS_MOVIES"))
    private Movie movie;
}
