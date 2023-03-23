package com.example.MyProject.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;
// BEAN CLASS
@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
    // RUN METHOD. RUNS WHEN ApplicationContext STARTS
        return args -> {
            Student ugur = new Student(

                    "Ugur",
                    "uur.dogan@hotmail.com",
                    LocalDate.of(2001, AUGUST, 16)
            );
            Student meric = new Student(

                    "Meric",
                    "meric.dogan@hotmail.com",
                    LocalDate.of(2014, AUGUST, 16)
            );
            repository.saveAll(
                    List.of(ugur,meric)
            );
        };

    }


}
