package ru.yandex.incoming34.passengers_and_tickets.repo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.yandex.incoming34.passengers_and_tickets.PassengersAndTicketsApplication;
import ru.yandex.incoming34.passengers_and_tickets.entity.PassengerWithTicket;
import ru.yandex.incoming34.passengers_and_tickets.entity.TicketWithoutPassengers;

import java.util.List;

@SpringBootTest(classes = {PassengerRepo.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= PassengersAndTicketsApplication.class)
class PassengerWithTicketRepoTest {

    private final PassengerRepo passengerRepo;

    PassengerWithTicketRepoTest(@Qualifier("passengerRepo")PassengerRepo passengerRepo) {
        this.passengerRepo = passengerRepo;
    }

    @Test
    public void findTest(){
        System.out.println(passengerRepo.findAll().get(0).toString());
    }

    @Test
    public void insertPassenger(){
        PassengerWithTicket passenger = new PassengerWithTicket("Andrew");
        List<TicketWithoutPassengers> ticketWithoutPassengersList = List.of(new TicketWithoutPassengers(67890),
                new TicketWithoutPassengers(987654),
                new TicketWithoutPassengers(3214),
                new TicketWithoutPassengers(842095791));
        passenger.setTickets(ticketWithoutPassengersList);
        passengerRepo.save(passenger);
    }

}