package ru.yandex.incoming34.passengers_and_tickets.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToOne
    @JoinColumn(name = "pass_id")
    @JsonBackReference
    @JsonIgnore
    private PassengerBrief passenger;

    public TicketBrief(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
