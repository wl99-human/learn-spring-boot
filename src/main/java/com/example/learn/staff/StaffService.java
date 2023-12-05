package com.example.learn.staff;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StaffService {
    public List<Staff> getStaff() {
        return List.of(new Staff(1L,"John", "johndabest@gmail.com",LocalDate.of(1999, Month.APRIL, 1), 24));
    }
}
