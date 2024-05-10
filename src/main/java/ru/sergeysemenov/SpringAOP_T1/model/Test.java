package ru.sergeysemenov.SpringAOP_T1.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tests")
@ToString
public class Test {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "test_id")
    private UUID id;

    @Column(name = "test_date")
    private Date testDate;

    private String topic;

}
