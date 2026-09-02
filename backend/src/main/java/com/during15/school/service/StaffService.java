package com.during15.school.service;

import com.during15.school.model.Staff;
import com.during15.school.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Optional<Staff> getStaffById(Long id) {
        return staffRepository.findById(id);
    }

    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff updateStaff(Long id, Staff staff) {
        Staff existing = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        existing.setStaffNumber(staff.getStaffNumber());
        existing.setFirstName(staff.getFirstName());
        existing.setLastName(staff.getLastName());
        existing.setEmail(staff.getEmail());
        existing.setPhone(staff.getPhone());

        return staffRepository.save(existing);
    }

    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}
