package ru.yandex.incoming34.passengers_and_tickets.repo;

import org.springframework.data.repository.CrudRepository;
import ru.yandex.incoming34.passengers_and_tickets.entity.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

    @Override
    Iterable<Customer> findAll();
}
