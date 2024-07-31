package ru.yandex.incoming34.passengers_and_tickets.repo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.yandex.incoming34.passengers_and_tickets.PassengersAndTicketsApplication;
import ru.yandex.incoming34.passengers_and_tickets.entity.PassengerDetailed;
import ru.yandex.incoming34.passengers_and_tickets.entity.TicketBrief;
import ru.yandex.incoming34.passengers_and_tickets.mapper.PostgreSQLRangeType;

import java.util.List;

@SpringBootTest(classes = {PassengerRepo.class, PostgreSQLRangeType.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= PassengersAndTicketsApplication.class)
class PassengerDetailedRepoTest {

    private final PassengerRepo passengerRepo;

    PassengerDetailedRepoTest(@Qualifier("passengerRepo")PassengerRepo passengerRepo) {
        this.passengerRepo = passengerRepo;
    }

    @Test
    public void findTest(){
        System.out.println(passengerRepo.findAll().get(0).toString());
    }

    @Test
    public void insertPassenger(){
        PassengerDetailed passenger = new PassengerDetailed("Boris");
        List<TicketBrief> ticketBriefList = List.of(new TicketBrief(67890),
                new TicketBrief(987654),
                new TicketBrief(3214),
                new TicketBrief(842095791));
        passenger.setTickets(ticketBriefList);
        passengerRepo.save(passenger);
    }

}