package edu.miu.spring_jpa;

import edu.miu.spring_jpa.domain.Address;
import edu.miu.spring_jpa.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import edu.miu.spring_jpa.repositories.StudentRepository;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("edu.miu.spring_jpa.repositories")
public class StudentApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Address address1 = new Address("1000 n 4th", "Fairfield", "IOWA");
		Address address2 = new Address("2000 W Court", "burlington", "IOWA");
		Address address3 = new Address("3000 Main St", "ottumwa", "IOWA");
		Address address4 = new Address("4000 East St", "oskaloosa", "IOWA");
		Address address5 = new Address("5000 South Ave", "kennedy", "IOWA");

		Student s1 = new Student("Sunil", "3434934834", "sunil@miu.edu", address1);
		Student s2 = new Student("Ram", "1111111111", "ram@miu.edu", address2);
		Student s3 = new Student("Shyam", "2222222222", "shyam@miu.edu", address3);
		Student s4 = new Student("Hari", "3333333333", "hari@miu.edu", address4);
		Student s5 = new Student("Gita", "4444444444", "gita@miu.edu", address5);

		studentRepository.saveAll(List.of(s1, s2, s3, s4, s5));

		System.out.println("-----------All Student ----------------");
		List<Student> allStudents = studentRepository.findAll();
		for (Student student : allStudents) {
			System.out.println(student);
		}

		System.out.println("-----------Find All Student By Name----------------");
		List<Student> studentsByName = studentRepository.findAllByName("Sunil");
		for (Student student : studentsByName) {
			System.out.println(student);
		}

		System.out.println("-----------find by phone ----------------");
		Student studentByPhone = studentRepository.findByPhoneNumber("3434934834");
		if (studentByPhone != null) {
			System.out.println(studentByPhone);
		} else {
			System.out.println("Student not found by phone number.");
		}

		System.out.println("-----------find by City ----------------");
		List<Student> studentsByCity = studentRepository.findAllByCity("fairfield");
		for (Student student : studentsByCity) {
			System.out.println(student);
		}
	}

}
