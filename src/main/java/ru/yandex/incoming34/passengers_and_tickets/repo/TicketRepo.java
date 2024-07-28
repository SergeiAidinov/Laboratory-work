package ru.yandex.incoming34.passengers_and_tickets.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.passengers_and_tickets.entity.TicketBrief;

@Repository
public interface TicketRepo extends CrudRepository<TicketBrief, Long> {
}
