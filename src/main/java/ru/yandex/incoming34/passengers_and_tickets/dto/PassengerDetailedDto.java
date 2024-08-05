package ru.yandex.incoming34.passengers_and_tickets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PassengerDetailedDto {
    private String name;
    private List<TicketBriefDto> tickets;

}
