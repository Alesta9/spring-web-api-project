package com.example.MyProject.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// DATA ACCESS LAYER - REPOSITORY
// CONNECTION BETWEEN DATABASE AND REPOSITORY WITH JPA
@Repository
public interface StudentRepository extends JpaRepository<Student, Long > {
// to relate Java Classes and Database Tables

    // SELECT * FROM student WHERE email = ?
    @Query("SELECT s from Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

}
