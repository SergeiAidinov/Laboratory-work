package ru.yandex.incoming34.passengers_and_tickets.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "passenger")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PassengerBrief extends AbstractPassenger{
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pass_id")
    @JsonBackReference
    private List<TicketBrief> tickets;
}
