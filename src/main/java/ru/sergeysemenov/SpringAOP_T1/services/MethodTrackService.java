package ru.sergeysemenov.SpringAOP_T1.services;

import ru.sergeysemenov.SpringAOP_T1.model.MethodExecutionTiming;

import java.util.List;

public interface MethodTrackService {

    List<MethodExecutionTiming> findAllTimings();

    List<MethodExecutionTiming> findAllTimingsWithAsyncTrack();

    double getAverageExecutionTiming();
}
