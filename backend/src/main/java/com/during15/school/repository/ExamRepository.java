package com.during15.school.repository;

import com.during15.school.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    List<Exam> findByExamDate(LocalDate examDate);

    List<Exam> findBySubjectSubjectId(Long subjectId);

    List<Exam> findBySchoolClassClassId(Long classId);

    List<Exam> findByExamNameContainingIgnoreCase(String examName);
}
