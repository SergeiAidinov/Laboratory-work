package ru.yandex.incoming34.passengers_and_tickets.repo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.yandex.incoming34.passengers_and_tickets.PassengersAndTicketsApplication;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {CustomerRepo.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= PassengersAndTicketsApplication.class)
class CustomerRepoTest {

    private final CustomerRepo customerRepo;

    CustomerRepoTest(@Qualifier("customerRepo")CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Test
    void findAll() {
        //System.out.println(customerRepo.findAll());
    }
}