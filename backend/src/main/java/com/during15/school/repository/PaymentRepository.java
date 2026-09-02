package com.during15.school.repository;

import com.during15.school.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByStudentStudentId(Long studentId);

    List<Payment> findByFeeStructureFeeId(Long feeId);
}
