package ru.yandex.incoming34.passengers_and_tickets.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.passengers_and_tickets.entity.PassengerDetailed;

import java.util.List;

@Repository
public interface PassengerRepo extends CrudRepository<PassengerDetailed, Long> {
    @Override
    List<PassengerDetailed> findAll();

    //@Override
    <S extends PassengerDetailed> S save(S entity);
}
