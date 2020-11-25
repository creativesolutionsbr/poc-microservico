package org.lab.poc.service.department.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.lab.poc.service.department.model.Department;
import org.lab.poc.service.department.repository.DepartmentRepository;

@Configuration
public class WebConfig {
    
    @Bean
    public DepartmentRepository repository() {
        DepartmentRepository repo = new DepartmentRepository();
        repo.add(new Department(1L, "Development"));
        repo.add(new Department(1L, "Operations"));
        repo.add(new Department(2L, "Development"));
        repo.add(new Department(2L, "Operations"));

        return repo;
    }
}
