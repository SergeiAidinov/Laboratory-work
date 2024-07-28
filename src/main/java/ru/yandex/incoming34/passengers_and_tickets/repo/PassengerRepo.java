package ru.yandex.incoming34.passengers_and_tickets.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.passengers_and_tickets.entity.PassengerWithTicket;

import java.util.List;

@Repository
public interface PassengerRepo extends CrudRepository<PassengerWithTicket, Long> {
    @Override
    List<PassengerWithTicket> findAll();

    //@Override
    <S extends PassengerWithTicket> S save(S entity);
}
