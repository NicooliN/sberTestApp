package ru.sber.test.app.sbertestapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sber.test.app.sbertestapp.model.Order;

public interface OrderRepository
        extends GenericRepository<Order> {
}
