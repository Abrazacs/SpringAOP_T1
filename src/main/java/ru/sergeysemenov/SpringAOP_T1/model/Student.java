package ru.sergeysemenov.SpringAOP_T1.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    @Id
    @UuidGenerator (style = UuidGenerator.Style.TIME)
    @Column(name = "student_id")
    private UUID studentId;
    private String name;
    private String surname;

}
