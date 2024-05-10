package ru.sergeysemenov.SpringAOP_T1.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sergeysemenov.SpringAOP_T1.model.TestResult;

import java.util.List;

import java.util.UUID;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, UUID> {
    List<TestResult> findAllByStudentId(UUID studentId);

}
