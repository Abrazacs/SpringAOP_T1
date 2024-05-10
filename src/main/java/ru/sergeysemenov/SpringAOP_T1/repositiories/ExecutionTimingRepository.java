package ru.sergeysemenov.SpringAOP_T1.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.sergeysemenov.SpringAOP_T1.model.MethodExecutionTiming;

import java.util.List;

@Repository
public interface ExecutionTimingRepository extends JpaRepository<MethodExecutionTiming, Long> {
    @Query(value = "SELECT * FROM method_execution_timings m WHERE m.is_async_track = true", nativeQuery = true)
    List<MethodExecutionTiming> findAllWithAsyncTrack();
}
