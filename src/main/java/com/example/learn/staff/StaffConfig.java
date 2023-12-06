package com.example.learn.staff;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StaffConfig {
    @Bean
    CommandLineRunner commandLineRunner(StaffRepository staffRepository) {
        return args -> {
            Staff ali = new Staff(
                    "Ali",
                    "ali64@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    21
            );

            Staff adam = new Staff(
                    "Adam",
                    "adam88@gmail.com",
                    LocalDate.of(2002, Month.NOVEMBER, 7),
                    22
            );

            staffRepository.saveAll(List.of(ali, adam));
        };
    }
}
