package com.during15.school.controller;

import com.during15.school.model.Grade;
import com.during15.school.service.GradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
@CrossOrigin
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        return gradeService.getGradeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/student/{studentId}")
    public List<Grade> getGradesByStudent(@PathVariable Long studentId) {
        return gradeService.getGradesByStudent(studentId);
    }

    @GetMapping("/exam/{examId}")
    public List<Grade> getGradesByExam(@PathVariable Long examId) {
        return gradeService.getGradesByExam(examId);
    }

    @PostMapping
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.createGrade(grade);
    }

    @PutMapping("/{id}")
    public Grade updateGrade(
            @PathVariable Long id,
            @RequestBody Grade grade) {
        return gradeService.updateGrade(id, grade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }
}
