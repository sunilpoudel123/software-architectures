package edu.miu.spring_jpa.repositories;

import edu.miu.spring_jpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByName(String name);

    Student findByPhoneNumber(String phoneNumber);

    @Query("select s from Student s where s.address.city = :city")
    List<Student> findAllByCity(String city);
}
