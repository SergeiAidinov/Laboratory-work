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
@NoArgsConstructor
public class PassengerWithTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pass_id")
    //@JsonIgnore
    @JsonManagedReference
    private List<TicketWithoutPassengers> tickets;

    public PassengerWithTicket(String name) {
        this.name = name;
    }
}
