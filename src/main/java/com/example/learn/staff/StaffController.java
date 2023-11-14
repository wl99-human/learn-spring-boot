package com.example.learn.staff;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/staff")
public class StaffController {
    @GetMapping
    public List<Staff> getStaff() {
        return List.of(new Staff(1L,"John", "johndabest@gmail.com", LocalDate.of(1999, Month.APRIL, 1), 24));
    }
}
