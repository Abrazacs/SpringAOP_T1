package ru.sergeysemenov.SpringAOP_T1.aspects;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.sergeysemenov.SpringAOP_T1.model.MethodExecutionTiming;
import ru.sergeysemenov.SpringAOP_T1.services.imp.MethodTrackServiceImp;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class TrackAsyncTimeAspect {
    private final MethodTrackServiceImp executionTimingService;
    @Pointcut("execution(@ru.sergeysemenov.SpringAOP_T1.annotations.TrackAsyncTime * *(..))")
    public void trackAsyncTimePointCut() { }

    @Around("trackAsyncTimePointCut()")
    public Object trackAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        long start = System.currentTimeMillis();
        Object output = joinPoint.proceed();
        CompletableFuture.runAsync(()->{
            long duration = System.currentTimeMillis() - start;
            MethodExecutionTiming methodExecutionTiming = executionTimingService.createExecutionTiming(methodName, duration, true);
            executionTimingService.save(methodExecutionTiming);
        });
        return output;
    }
}
