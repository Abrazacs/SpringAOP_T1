package ru.sergeysemenov.SpringAOP_T1.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sergeysemenov.SpringAOP_T1.model.Student;


import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student,UUID> {
    Student findByStudentId(UUID studentId);


}
