package com.during15.school.repository;

import com.during15.school.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByStudentStudentId(Long studentId);

    List<Attendance> findByAttendanceDate(LocalDate attendanceDate);

    List<Attendance> findByStudentStudentIdAndAttendanceDate(
            Long studentId,
            LocalDate attendanceDate
    );
}
