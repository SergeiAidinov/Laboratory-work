package ru.yandex.incoming34.passengers_and_tickets.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "passenger")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PassengerBrief extends AbstractPassenger{
}
