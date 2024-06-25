package com.example.fulldemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {
    private static final Logger Log = LoggerFactory.getLogger(LoadDataBase.class);

    /*
    * The runner request a copy of EmployeeRepository
    * Create a preloads
    * */
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            Log.info("Preload" + employeeRepository.save(new Employee("Bilbo Baggins", "burglar")));
            Log.info("Preload" + employeeRepository.save(new Employee("Frodo Baggins", "thief")));
        };
    }
}

/*Output should be
* INFO 74611 --- [main] payroll.LoadDatabase : Preloading Employee(id=1, name=Bilbo Baggins, role=burglar)
* INFO 74611 --- [main] payroll.LoadDatabase : Preloading Employee(id=2, name=Frodo Baggins, role=thief)
*/