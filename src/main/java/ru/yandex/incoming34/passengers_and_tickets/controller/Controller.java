package ru.yandex.incoming34.passengers_and_tickets.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.incoming34.passengers_and_tickets.entity.PassengerDetailed;
import ru.yandex.incoming34.passengers_and_tickets.entity.TicketDetailed;
import ru.yandex.incoming34.passengers_and_tickets.repo.PassengerRepo;
import ru.yandex.incoming34.passengers_and_tickets.repo.TicketRepo;
import ru.yandex.incoming34.passengers_and_tickets.repo.TicketWithPassengerRepo;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/controller")
public class Controller {

    private final PassengerRepo passengerRepo;
    private final TicketRepo ticketRepo;
    private final TicketWithPassengerRepo ticketWithPassengerRepo;

    @GetMapping("/all_passengers")
    public List<PassengerDetailed> findAllPassengers() {
        return passengerRepo.findAll();
    }

    @GetMapping("/all_tickets")
    public Iterable<TicketDetailed> findAllTickets() {
        return ticketWithPassengerRepo.findAll();
    }
}
