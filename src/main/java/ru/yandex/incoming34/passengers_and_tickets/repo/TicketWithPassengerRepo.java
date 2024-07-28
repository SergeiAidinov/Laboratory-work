package ru.yandex.incoming34.passengers_and_tickets.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.passengers_and_tickets.entity.TicketDetailed;

@Repository
public interface TicketWithPassengerRepo extends CrudRepository<TicketDetailed, Long> {

    @Override
    Iterable<TicketDetailed> findAll();
}
