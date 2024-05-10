package ru.sergeysemenov.SpringAOP_T1.services;

import ru.sergeysemenov.SpringAOP_T1.model.Student;
import ru.sergeysemenov.SpringAOP_T1.model.Test;

import java.util.List;
import java.util.UUID;

public interface TestService {
    Test findTestById(UUID id);
    List<Test> findAllTests();

    int getMarkForTest(Student student, Test test);
}
