package com.example.learn.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }
    public List<Staff> getStaff() {
        return staffRepository.findAll();
    }

    public void addNewStaff(Staff staff) {
        Optional<Staff> staffOptional = staffRepository.findStaffByEmail(staff.getEmail());
        if (staffOptional.isPresent()) {
            throw new IllegalStateException("Email is taken");
        }
        staffRepository.save(staff);
    }

    public void deleteStaff(Long staffId) {
        boolean existsStaff = staffRepository.existsById(staffId);
        if (!existsStaff) {
            throw new IllegalStateException("Staff with ID "+staffId+ " does not exists");
        }
        staffRepository.deleteById(staffId);
    }
}
