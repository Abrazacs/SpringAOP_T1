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

@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class TrackTimeAspect {
    private final MethodTrackServiceImp executionTimingService;

    @Pointcut("execution(@ru.sergeysemenov.SpringAOP_T1.annotations.TrackTime * *(..))")
    public void trackTimePointCut() {
    }

    @Around(value = "trackTimePointCut()")
    public Object trackAround(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        try {
            String methodName = joinPoint.getSignature().getName();
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - start;
            MethodExecutionTiming methodExecutionTiming = executionTimingService.createExecutionTiming(methodName, duration, false);
            executionTimingService.save(methodExecutionTiming);
            return result;
        }catch (Throwable e){
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
