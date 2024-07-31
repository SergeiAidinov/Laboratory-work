package ru.yandex.incoming34.passengers_and_tickets.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ticket")
@Getter
@NoArgsConstructor
public class TicketBrief {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ticketId;
    @Column(name = "ticket_number")
    private Integer ticketNumber;

    public TicketBrief(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
