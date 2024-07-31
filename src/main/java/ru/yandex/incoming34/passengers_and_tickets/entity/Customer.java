package ru.yandex.incoming34.passengers_and_tickets.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.hypersistence.utils.hibernate.type.range.Range;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
@Getter
@NoArgsConstructor
public class Customer {

    @Id
    private Long id;
    @Column(name = "customer_name")
    private String firstName;
    @Column(name = "customer_surname")
    private String lastName;
    @Column(
            name = "active_period",
            columnDefinition = "tstzrange"
    )
    @JsonIgnore
    private Range<LocalDate> actionTime;

    private transient LocalDateTime startTime;
    private transient boolean startTimeIncluded;
    private transient LocalDateTime endTime;
    private transient boolean endTimeIncluded;

    @PostLoad
    private void init(){
        startTime = LocalDateTime.from(actionTime.lower());
        startTimeIncluded = actionTime.isLowerBoundClosed();
        endTime = LocalDateTime.from(actionTime.upper());
        endTimeIncluded = actionTime.isUpperBoundClosed();
    }
}
