package ru.sber.test.app.sbertestapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.sber.test.app.sbertestapp.model.GenericModel;

@NoRepositoryBean
public interface GenericRepository <T extends GenericModel>
        extends JpaRepository<T, Long> {
}
