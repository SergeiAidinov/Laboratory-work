package ru.yandex.incoming34.passengers_and_tickets.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.passengers_and_tickets.entity.Passenger;

import java.util.List;

@Repository
public interface PassengerRepo extends CrudRepository<Passenger, Long> {
    @Override
    List<Passenger> findAll();

    //@Override
    <S extends Passenger> S save(S entity);
}
