package ru.yandex.incoming34.passengers_and_tickets.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loaded_file")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoadedFile {

    @Id
    @Column(name = "file_name")
    private String id;
    @Column(name = "file_body")
    private byte[] fileBody;
}
