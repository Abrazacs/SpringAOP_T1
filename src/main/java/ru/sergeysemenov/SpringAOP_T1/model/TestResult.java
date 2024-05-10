package ru.sergeysemenov.SpringAOP_T1.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "test_results")
@ToString
public class TestResult {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id")
    private UUID id;
    private String topic;

    private UUID studentId;

    private int mark;

}
