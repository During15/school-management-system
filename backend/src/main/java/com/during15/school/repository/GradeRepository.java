package com.during15.school.repository;

import com.during15.school.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    List<Grade> findByStudentStudentId(Long studentId);

    List<Grade> findByExamExamId(Long examId);
}
