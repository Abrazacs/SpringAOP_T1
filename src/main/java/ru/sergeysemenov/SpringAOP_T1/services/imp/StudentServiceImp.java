package ru.sergeysemenov.SpringAOP_T1.services.imp;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergeysemenov.SpringAOP_T1.annotations.TrackTime;
import ru.sergeysemenov.SpringAOP_T1.model.Student;

import ru.sergeysemenov.SpringAOP_T1.repositiories.StudentRepository;
import ru.sergeysemenov.SpringAOP_T1.services.StudentService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepository;

    public Student findByStudentId(UUID studentId){
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + studentId));
    }

    @TrackTime
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

}
