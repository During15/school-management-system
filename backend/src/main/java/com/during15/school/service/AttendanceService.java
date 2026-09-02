package com.during15.school.service;

import com.during15.school.model.Attendance;
import com.during15.school.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }

    public List<Attendance> getByStudent(Long studentId) {
        return attendanceRepository.findByStudentStudentId(studentId);
    }

    public List<Attendance> getByDate(LocalDate date) {
        return attendanceRepository.findByAttendanceDate(date);
    }

    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance attendance) {
        Attendance existing = attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));

        existing.setStudent(attendance.getStudent());
        existing.setAttendanceDate(attendance.getAttendanceDate());
        existing.setStatus(attendance.getStatus());

        return attendanceRepository.save(existing);
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
