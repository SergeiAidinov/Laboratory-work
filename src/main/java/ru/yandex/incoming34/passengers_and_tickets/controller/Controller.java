package ru.yandex.incoming34.passengers_and_tickets.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.yandex.incoming34.passengers_and_tickets.dto.PassengerDetailedDto;
import ru.yandex.incoming34.passengers_and_tickets.dto.PassengersDto;
import ru.yandex.incoming34.passengers_and_tickets.entity.Customer;
import ru.yandex.incoming34.passengers_and_tickets.entity.LoadedFile;
import ru.yandex.incoming34.passengers_and_tickets.entity.PassengerDetailed;
import ru.yandex.incoming34.passengers_and_tickets.entity.TicketDetailed;
import ru.yandex.incoming34.passengers_and_tickets.repo.*;
import ru.yandex.incoming34.passengers_and_tickets.service.FileLoader;
import ru.yandex.incoming34.passengers_and_tickets.service.FileSaver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping("/controller")
public class Controller {

    private final PassengerRepo passengerRepo;
    private final TicketRepo ticketRepo;
    private final TicketWithPassengerRepo ticketWithPassengerRepo;
    private final CustomerRepo customerRepo;
    private final FileLoader fileLoader;
    private final LoadedFilesRepo loadedFilesRepo;
    private final FileSaver fileSaver;

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
    public void newCustomer(HttpServletRequest request, @RequestBody PassengerDetailedDto passengerDetailedDto) {
        System.out.println(request.getParameterValues("name"));
        System.out.println(request.getParameterMap());
        System.out.println(passengerDetailedDto);
        System.out.println();
    }

    @DeleteMapping(path = "/call")
    public void deleteCall() {
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
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        long start = System.currentTimeMillis();
        fileLoader.loadFile(multipartFile);
        return "Файл загружен за " + (System.currentTimeMillis() - start) + " ms.";
    }

    @PutMapping(path = "/download_file")
    public boolean downloadFile(String fileName) {
        LoadedFile loadedFile = loadedFilesRepo.findById(fileName).orElseThrow(NoSuchElementException::new);
        return fileSaver.saveFile(loadedFile);
    }
}
