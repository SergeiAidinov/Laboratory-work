package ru.yandex.incoming34.passengers_and_tickets.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
}
