package com.elec5619.bloodsystem.config;

import com.elec5619.bloodsystem.dao.StudentRepository;
import com.elec5619.bloodsystem.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student chen = new Student(
                    "chen",
                    "chen@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)

            );


            Student zhang = new Student(
                    "zhang",
                    "zhang@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            studentRepository.saveAll(List.of(chen, zhang));
        };
    }
}
