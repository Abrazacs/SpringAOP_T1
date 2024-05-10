package ru.sergeysemenov.SpringAOP_T1.services.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergeysemenov.SpringAOP_T1.model.Student;
import ru.sergeysemenov.SpringAOP_T1.model.Test;
import ru.sergeysemenov.SpringAOP_T1.model.TestResult;
import ru.sergeysemenov.SpringAOP_T1.repositiories.TestResultRepository;
import ru.sergeysemenov.SpringAOP_T1.services.TestResultService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestResultServiceImp implements TestResultService {
    private final TestResultRepository testResultRepository;

    @Override
    public void addTestResult(Test test, Student student, int mark) {
        TestResult testResult = new TestResult();
        testResult.setStudentId(student.getStudentId());
        testResult.setTopic(test.getTopic());
        testResult.setMark(mark);
        testResultRepository.save(testResult);
    }

    @Override
    public List<TestResult> findAllByStudentId(UUID studentId) {
        return testResultRepository.findAllByStudentId(studentId);
    }
}
