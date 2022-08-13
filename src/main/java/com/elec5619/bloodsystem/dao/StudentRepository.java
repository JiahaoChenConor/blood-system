package com.elec5619.bloodsystem.dao;

import com.elec5619.bloodsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    // This is jbql and to be more explicit, you can comment out below row, "Student" is our class

    //    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
