package ru.sergeysemenov.SpringAOP_T1.services.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergeysemenov.SpringAOP_T1.model.MethodExecutionTiming;
import ru.sergeysemenov.SpringAOP_T1.repositiories.ExecutionTimingRepository;
import ru.sergeysemenov.SpringAOP_T1.services.MethodTrackService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MethodTrackServiceImp implements MethodTrackService {
    private final ExecutionTimingRepository executionTimingRepository;
    @Override
    public List<MethodExecutionTiming> findAllTimings() {
        return executionTimingRepository.findAll();
    }

    @Override
    public List<MethodExecutionTiming> findAllTimingsWithAsyncTrack() {
        return executionTimingRepository.findAllWithAsyncTrack();
    }

    @Override
    public double getAverageExecutionTiming() {
        List<MethodExecutionTiming> methodExecutionTimings = executionTimingRepository.findAll();
        return methodExecutionTimings.stream()
                .mapToLong(MethodExecutionTiming::getExecutionTime)
                .average()
                .orElse(0.0);
    }

    public MethodExecutionTiming createExecutionTiming(String methodName, long executionTime, boolean isAsyncTrack) {
        MethodExecutionTiming methodExecutionTiming = new MethodExecutionTiming();
        methodExecutionTiming.setMethodName(methodName);
        methodExecutionTiming.setExecutionTime(executionTime);
        methodExecutionTiming.setAsyncTrack(isAsyncTrack);
        return methodExecutionTiming;
    }

    public void save(MethodExecutionTiming methodExecutionTiming) {
        executionTimingRepository.save(methodExecutionTiming);
    }
}
