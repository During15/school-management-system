package com.during15.school.service;

import com.during15.school.model.Grade;
import com.during15.school.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }

    public List<Grade> getGradesByStudent(Long studentId) {
        return gradeRepository.findByStudentStudentId(studentId);
    }

    public List<Grade> getGradesByExam(Long examId) {
        return gradeRepository.findByExamExamId(examId);
    }

    public Grade createGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade updateGrade(Long id, Grade gradeDetails) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grade not found"));

        grade.setStudent(gradeDetails.getStudent());
        grade.setExam(gradeDetails.getExam());
        grade.setMarks(gradeDetails.getMarks());
        grade.setGrade(gradeDetails.getGrade());
        grade.setRemarks(gradeDetails.getRemarks());

        return gradeRepository.save(grade);
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}
