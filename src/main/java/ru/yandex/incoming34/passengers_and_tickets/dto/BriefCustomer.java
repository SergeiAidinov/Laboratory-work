package ru.yandex.incoming34.passengers_and_tickets.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BriefCustomer {

    @JsonProperty("name")
    private String name;
}
