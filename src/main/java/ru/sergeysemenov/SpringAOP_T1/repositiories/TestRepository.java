package ru.sergeysemenov.SpringAOP_T1.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sergeysemenov.SpringAOP_T1.model.Test;

import java.util.UUID;

@Repository
public interface TestRepository extends JpaRepository<Test, UUID> {

}
