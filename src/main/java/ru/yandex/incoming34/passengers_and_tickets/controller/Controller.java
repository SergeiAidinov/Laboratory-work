package ru.yandex.incoming34.passengers_and_tickets.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.incoming34.passengers_and_tickets.entity.Passenger;
import ru.yandex.incoming34.passengers_and_tickets.entity.Ticket;
import ru.yandex.incoming34.passengers_and_tickets.repo.PassengerRepo;
import ru.yandex.incoming34.passengers_and_tickets.repo.TicketRepo;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/controller")
public class Controller {

    private final PassengerRepo passengerRepo;
    private final TicketRepo ticketRepo;

    @GetMapping("/all_passengers")
    public List<Passenger> findAllPassengers() {
        return passengerRepo.findAll();
    }

    @GetMapping("/all_tickets")
    public Iterable<Ticket> findAllTickets() {
        return ticketRepo.findAll();
    }


}
