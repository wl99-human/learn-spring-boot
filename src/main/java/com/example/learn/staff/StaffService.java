package com.example.learn.staff;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Transactional
    public void updateStaff(Long staffId, String name, String email) {
        Staff existsStaff = staffRepository.findById(staffId)
                .orElseThrow(() -> new IllegalStateException(
                "Staff with ID "+staffId+"does not exists"
        ));

        if (name != null && !name.isEmpty() && !Objects.equals(existsStaff.getName(), name)) {
            existsStaff.setName(name);
        }

        if (email != null && !email.isEmpty() && !Objects.equals(existsStaff.getEmail(), email)) {
            Optional<Staff> staffOptional = staffRepository.findStaffByEmail(email);
            if (staffOptional.isPresent()) {
                throw new IllegalStateException("Email is taken. Please use another email");
            }
            existsStaff.setEmail(email);
        }
    }
}
