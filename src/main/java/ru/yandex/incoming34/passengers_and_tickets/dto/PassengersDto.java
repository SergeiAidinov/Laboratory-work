package ru.yandex.incoming34.passengers_and_tickets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.yandex.incoming34.passengers_and_tickets.entity.PassengerDetailed;

import java.util.List;
@AllArgsConstructor
@Getter
public class PassengersDto {
    private final String cookieUser;
    private final List<PassengerDetailed> passengerDetailedList;
}
