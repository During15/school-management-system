package com.during15.school.repository;

import com.during15.school.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    Optional<Staff> findByStaffNumber(String staffNumber);

    Optional<Staff> findByEmail(String email);

    boolean existsByStaffNumber(String staffNumber);

    boolean existsByEmail(String email);
}
