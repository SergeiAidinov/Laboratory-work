package ru.yandex.incoming34.passengers_and_tickets.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ticket")
@Getter
@ToString
@NoArgsConstructor
public class TicketWithoutPassengers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ticketId;
    @Column(name = "ticket_number")
    private Integer ticketNumber;
    @ManyToOne
    @JoinColumn(name = "pass_id")
    @JsonBackReference
    private PassengerWithTicket passenger;

    public TicketWithoutPassengers(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
