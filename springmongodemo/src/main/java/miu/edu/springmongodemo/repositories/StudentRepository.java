package miu.edu.springmongodemo.repositories;

import miu.edu.springmongodemo.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, Integer> {

    List<Student> findAllByName(String name);

    Student findByPhoneNumber(String phoneNumber);

    @Query("select s from Student s where s.address.city = :city")
    List<Student> findAllByCity(String city);
}
