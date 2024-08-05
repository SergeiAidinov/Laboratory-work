package ru.yandex.incoming34.passengers_and_tickets.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.yandex.incoming34.passengers_and_tickets.dto.BriefCustomer;
import ru.yandex.incoming34.passengers_and_tickets.dto.PassengerDetailedDto;
import ru.yandex.incoming34.passengers_and_tickets.dto.PassengersDto;
import ru.yandex.incoming34.passengers_and_tickets.dto.Person;
import ru.yandex.incoming34.passengers_and_tickets.entity.Customer;
import ru.yandex.incoming34.passengers_and_tickets.entity.PassengerDetailed;
import ru.yandex.incoming34.passengers_and_tickets.entity.TicketDetailed;
import ru.yandex.incoming34.passengers_and_tickets.repo.CustomerRepo;
import ru.yandex.incoming34.passengers_and_tickets.repo.PassengerRepo;
import ru.yandex.incoming34.passengers_and_tickets.repo.TicketRepo;
import ru.yandex.incoming34.passengers_and_tickets.repo.TicketWithPassengerRepo;
import ru.yandex.incoming34.passengers_and_tickets.service.FileLoader;

import java.io.IOException;
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
    private final FileLoader fileLoader;

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

    @DeleteMapping(path = "/new_customer")
    public void newCustomer(HttpServletRequest request , @RequestBody PassengerDetailedDto passengerDetailedDto) {
        System.out.println(request.getParameterValues("name"));
        System.out.println(request.getParameterMap());
        System.out.println(passengerDetailedDto);
        System.out.println();
    }

    @DeleteMapping(path = "/call")
    public void deleteCall(){
        System.out.println("DELETE CALLED!");
    }

    @PostMapping(path = "/post_new_customer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PassengerDetailedDto postNewCustomer(@RequestBody PassengerDetailedDto passengerDetailedDto) {
        /*System.out.println(request.getParameterValues("name"));
        System.out.println(request.getParameterMap());*/
        //System.out.println(person);
        System.out.println("POST NEW CUSTOMER: " + passengerDetailedDto);
        return passengerDetailedDto;
    }

    @PostMapping(path = "/file", consumes = {"multipart/form-data"})
    public String loadFile(@RequestParam("file") MultipartFile file) throws IOException {
        long start = System.currentTimeMillis();
        fileLoader.loadFile(file);
        return "Файл загружен за " + (System.currentTimeMillis() - start) + " ms.";
    }

}
