package ru.yandex.incoming34.passengers_and_tickets.repo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.yandex.incoming34.passengers_and_tickets.PassengersAndTicketsApplication;
import ru.yandex.incoming34.passengers_and_tickets.entity.Passenger;
import ru.yandex.incoming34.passengers_and_tickets.entity.Ticket;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {PassengerRepo.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= PassengersAndTicketsApplication.class)
class PassengerRepoTest {

    private final PassengerRepo passengerRepo;

    PassengerRepoTest(@Qualifier("passengerRepo")PassengerRepo passengerRepo) {
        this.passengerRepo = passengerRepo;
    }

    @Test
    public void findTest(){
        System.out.println(passengerRepo.findAll().get(0).toString());
    }

    @Test
    public void insertPassenger(){
        Passenger passenger = new Passenger("Andrew");
        List<Ticket> ticketList = List.of(new Ticket(67890),
                new Ticket(987654),
                new Ticket(3214),
                new Ticket(842095791));
        passenger.setTickets(ticketList);
        passengerRepo.save(passenger);
    }

}