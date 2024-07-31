package ru.yandex.incoming34.passengers_and_tickets.entity;

import io.hypersistence.utils.hibernate.type.range.PostgreSQLRangeType;
import io.hypersistence.utils.hibernate.type.range.Range;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.TypeDef;

import java.time.LocalDate;

@Entity
@Table(name = "customer")
@Data
@TypeDef(typeClass = PostgreSQLRangeType.class, defaultForType = Range.class)
public class Customer {
    @Id
    private Long id;
    @Column(name = "customer_name")
    private String firstName;
    @Column(name = "customer_surname")
    private String lastName;
    @javax.persistence.Column(name = "active_period")
    @Column(
            name = "active_period",
            columnDefinition = "tstzrange"
    )
    private Range<LocalDate> actionTime;

}
