package ru.yandex.incoming34.passengers_and_tickets.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.incoming34.passengers_and_tickets.dto.BriefCustomer;
import ru.yandex.incoming34.passengers_and_tickets.dto.PassengersDto;
import ru.yandex.incoming34.passengers_and_tickets.entity.Customer;
import ru.yandex.incoming34.passengers_and_tickets.entity.PassengerDetailed;
import ru.yandex.incoming34.passengers_and_tickets.entity.TicketDetailed;
import ru.yandex.incoming34.passengers_and_tickets.repo.CustomerRepo;
import ru.yandex.incoming34.passengers_and_tickets.repo.PassengerRepo;
import ru.yandex.incoming34.passengers_and_tickets.repo.TicketRepo;
import ru.yandex.incoming34.passengers_and_tickets.repo.TicketWithPassengerRepo;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/controller")
public class Controller {

    private final PassengerRepo passengerRepo;
    private final TicketRepo ticketRepo;
    private final TicketWithPassengerRepo ticketWithPassengerRepo;
    private final CustomerRepo customerRepo;

    @GetMapping("/all_passengers")
    public ResponseEntity<PassengersDto> findAllPassengers(HttpServletRequest request, HttpServletResponse response) {
        final List<PassengerDetailed> result = passengerRepo.findAll();
        Cookie[] requestCookies = request.getCookies();
        Cookie cc = requestCookies[0];
        String cookieUsername = cc.getValue();
        Cookie cookie = new Cookie("user", UUID.randomUUID().toString());
        cookie.setMaxAge(30 * 60);
        response.addCookie(cookie);
        PassengersDto passengersDto = new PassengersDto(cookieUsername, result);
        ResponseEntity responseEntity = ResponseEntity.ok(passengersDto);
        return responseEntity;
    }

    @GetMapping("/all_tickets")
    public Iterable<TicketDetailed> findAllTickets() {
        return ticketWithPassengerRepo.findAll();
    }

    @GetMapping("/customers")
    public Iterable<Customer> customers() {
        Iterable<Customer> customers = customerRepo.findAll();
        return customers;
    }

    @DeleteMapping(path = "/new_customer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void newCustomer(HttpServletRequest request, BriefCustomer briefCustomer) {
        System.out.println(request.getParameterValues("name"));
        System.out.println(request.getParameterMap());
        //System.out.println(briefCustomer);
        System.out.println();
    }

}
