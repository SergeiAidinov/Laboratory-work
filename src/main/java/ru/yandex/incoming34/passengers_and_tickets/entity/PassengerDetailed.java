package ru.yandex.incoming34.passengers_and_tickets.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "passenger")
@Getter
@Setter
@ToString
public class PassengerDetailed extends AbstractPassenger{

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pass_id")
    @JsonManagedReference
    private List<TicketBrief> tickets;

    public PassengerDetailed(String passengerName) {
        super(passengerName);
    }

    public PassengerDetailed() {

    }
}
