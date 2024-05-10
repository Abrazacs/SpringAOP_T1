package ru.sergeysemenov.SpringAOP_T1;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ru.sergeysemenov.SpringAOP_T1.model.Student;
import ru.sergeysemenov.SpringAOP_T1.model.Test;
import ru.sergeysemenov.SpringAOP_T1.model.TestResult;
import ru.sergeysemenov.SpringAOP_T1.services.imp.StudentServiceImp;
import ru.sergeysemenov.SpringAOP_T1.services.imp.TestResultServiceImp;
import ru.sergeysemenov.SpringAOP_T1.services.imp.TestServiceImp;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class SpringAopT1Application {
	private StudentServiceImp studentService;
	private TestServiceImp testService;
	private TestResultServiceImp testResultService;

	public static void main(String[] args) {
		SpringApplication.run(SpringAopT1Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReady() {
		List<Test> tests = testService.findAllTests();
		List<Student> students = studentService.findAllStudents();
		tests.forEach(test ->{
			students.forEach(student -> {
				int mark = testService.getMarkForTest(student, test);
				testResultService.addTestResult(test, student, mark);
			});
		});
		Student student = students.get(0);
		List<TestResult> results = testResultService.findAllByStudentId(student.getStudentId());
		System.out.println(student.getName());
		results.forEach(System.out::println);

	}
}
