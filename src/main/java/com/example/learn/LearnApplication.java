package com.example.learn;

import com.example.learn.staff.Staff;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class LearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
	}

	@GetMapping
	public List<Staff> get() {
		return List.of(new Staff(1L,"John", "johndabest@gmail.com", LocalDate.of(1999, Month.APRIL, 1), 24));
	}
}
