package com.example.learn.staff;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class StaffService {
    public List<Staff> getStaff() {
        return List.of(new Staff(1L,"John", "johndabest@gmail.com",LocalDate.of(1999, Month.APRIL, 1), 24));
    }
}
