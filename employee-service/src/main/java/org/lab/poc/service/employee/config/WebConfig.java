package org.lab.poc.service.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.lab.poc.service.employee.model.Employee;
import org.lab.poc.service.employee.repository.EmployeeRepository;

@Configuration
public class WebConfig {
    
    @Bean
    public EmployeeRepository repository() {
        EmployeeRepository repo = new EmployeeRepository();
        repo.add(new Employee(1L, 1L, "John Smith", 34, "Analyst"));
        repo.add(new Employee(1L, 1L, "Darren Hamilton", 37, "Manager"));
        repo.add(new Employee(1L, 1L, "Tom Scott", 26, "Developer"));
        repo.add(new Employee(1L, 2L, "Anna London", 39, "Analyst"));
        repo.add(new Employee(1L, 2L, "Patrick Dempsey", 27, "Developer"));
        repo.add(new Employee(2L, 3L, "Kevin Price", 38, "Developer"));
        repo.add(new Employee(2L, 3L, "Ian Scott", 34, "Developer"));
        repo.add(new Employee(2L, 3L, "Andrew Campton", 30, "Manager"));
        repo.add(new Employee(2L, 4L, "Steve Franklin", 25, "Developer"));
        repo.add(new Employee(2L, 4L, "Elisabeth Smith", 30, "Developer"));

        return repo;
    }
}
