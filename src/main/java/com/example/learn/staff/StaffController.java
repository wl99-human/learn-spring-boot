package com.example.learn.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/staff")
public class StaffController {
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }
    @GetMapping
    public List<Staff> getStaff() {
        return staffService.getStaff();
    }

    @PostMapping
    public void registerNewStaff(@RequestBody Staff staff) {
        staffService.addNewStaff(staff);
    }
}
