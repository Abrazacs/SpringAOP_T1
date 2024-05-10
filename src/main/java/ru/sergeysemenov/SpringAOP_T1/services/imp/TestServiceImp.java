package ru.sergeysemenov.SpringAOP_T1.services.imp;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergeysemenov.SpringAOP_T1.annotations.TrackAsyncTime;
import ru.sergeysemenov.SpringAOP_T1.annotations.TrackTime;
import ru.sergeysemenov.SpringAOP_T1.model.Student;
import ru.sergeysemenov.SpringAOP_T1.model.Test;
import ru.sergeysemenov.SpringAOP_T1.repositiories.TestRepository;
import ru.sergeysemenov.SpringAOP_T1.services.TestService;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestServiceImp implements TestService {
    private final TestRepository testRepository;
    private final static int MAX_MARK = 5;
    private final static int MIN_MARK = 2;

    @Override
    public Test findTestById(UUID id)  {
        return testRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Test with id"+id+" not found"));
    }

    @Override
    public List<Test> findAllTests() {
        return testRepository.findAll();
    }

    @Override
    @TrackAsyncTime
    public int getMarkForTest(Student student, Test test) {
        if(!student.getName().equals("Хорус")) {
            return getRandomMarkBetweenTwoAndFive();
        }else{
            return  getMarkForChorus(test);
        }
    }

    private int getMarkForChorus(Test test) {
        if(test.getTopic().equals("География Империума")){
            return getRandomMarkBetweenTwoAndFive();
        }else return 2;

    }

    private static int getRandomMarkBetweenTwoAndFive() {
        Random random = new Random();
        return random.nextInt(MAX_MARK - MIN_MARK + 1) + MIN_MARK;
    }


}
