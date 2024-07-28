package ru.yandex.incoming34.passengers_and_tickets.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ticket")
@Getter
@ToString
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ticketId;
    @Column(name = "ticket_number")
    private Integer ticketNumber;
    @ManyToOne
    @JoinColumn(name = "pass_id")
    private Passenger passenger;
    public Ticket(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
