package ru.sergeysemenov.SpringAOP_T1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "method_execution_timings")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MethodExecutionTiming {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;
    private String methodName;
    private long executionTime;
    private boolean isAsyncTrack;

}
