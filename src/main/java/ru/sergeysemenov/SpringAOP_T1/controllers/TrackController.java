package ru.sergeysemenov.SpringAOP_T1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergeysemenov.SpringAOP_T1.model.MethodExecutionTiming;
import ru.sergeysemenov.SpringAOP_T1.services.imp.MethodTrackServiceImp;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/track")
public class TrackController {
    private final MethodTrackServiceImp trackService;

    @GetMapping("/methods")
    public List<MethodExecutionTiming> getTimings() {
        return trackService.findAllTimings();
    }

    @GetMapping("/methods/avg")
    public double getAvgTiming() {
        return trackService.getAverageExecutionTiming();
    }

    @GetMapping("/methods/async")
    public List<MethodExecutionTiming> getAsyncTimings() {
        return trackService.findAllTimingsWithAsyncTrack();
    }


}
