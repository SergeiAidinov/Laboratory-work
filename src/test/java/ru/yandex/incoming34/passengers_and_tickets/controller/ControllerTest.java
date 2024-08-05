package ru.yandex.incoming34.passengers_and_tickets.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.yandex.incoming34.passengers_and_tickets.PassengersAndTicketsApplication;
import ru.yandex.incoming34.passengers_and_tickets.dto.PassengerDetailedDto;
import ru.yandex.incoming34.passengers_and_tickets.dto.TicketBriefDto;
import ru.yandex.incoming34.passengers_and_tickets.repo.CustomerRepo;
import ru.yandex.incoming34.passengers_and_tickets.repo.PassengerRepo;
import ru.yandex.incoming34.passengers_and_tickets.repo.TicketRepo;
import ru.yandex.incoming34.passengers_and_tickets.repo.TicketWithPassengerRepo;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {Controller.class, PassengerRepo.class,
        TicketRepo.class, TicketWithPassengerRepo.class, CustomerRepo.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PassengersAndTicketsApplication.class)
class ControllerTest {

    private final Controller controller;

    ControllerTest(@Qualifier("controller") Controller controller) {
        this.controller = controller;
    }

    //@Test
    void newCustomer() throws IOException {
        System.out.println(controller);
        URL url = new URL("http://localhost:8080/controller/new_customer");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestProperty(
                "Content-Type", "application/json");
        httpCon.setRequestMethod("DELETE");
        OutputStreamWriter out = new OutputStreamWriter(
                httpCon.getOutputStream());
        ObjectMapper objectMapper = new ObjectMapper();
        out.write(objectMapper.writeValueAsString(new PassengerDetailedDto("sergei", List.of(new TicketBriefDto(314)))));
        out.close();
        httpCon.connect();
    }
}