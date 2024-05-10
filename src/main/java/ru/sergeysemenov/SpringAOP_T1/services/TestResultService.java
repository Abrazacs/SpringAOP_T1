package ru.sergeysemenov.SpringAOP_T1.services;

import ru.sergeysemenov.SpringAOP_T1.model.Student;
import ru.sergeysemenov.SpringAOP_T1.model.Test;
import ru.sergeysemenov.SpringAOP_T1.model.TestResult;

import java.util.List;
import java.util.UUID;

public interface TestResultService {

     void addTestResult(Test test, Student student, int mark);

     List<TestResult> findAllByStudentId(UUID studentId);

}
