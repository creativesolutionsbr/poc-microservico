package org.lab.poc.service.employee.controller;

import java.util.List;

import org.lab.poc.service.employee.model.Employee;
import org.lab.poc.service.employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@OpenAPIDefinition(
    info = @Info(title = "Employee API", version = "1.0", description = "Documentation Employee API v1.0")
)
public class EmployeeController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeRepository repo;

    public EmployeeController(EmployeeRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/")
    public Employee addEmployee(@RequestBody Employee employee) {
        LOGGER.info("Employee add: {}", employee);
        return repo.add(employee);
    }

    @GetMapping("/")
    public List<Employee> findAll() {
        LOGGER.info("Employee findAll");
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        LOGGER.info("Employee find: id={}", id);
        return repo.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Employee find: departmentId={}", departmentId);
        return repo.findByDepartment(departmentId);
    }

    @GetMapping("/organization/{organizationId}")
    public List<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Employee find: organizationId={}", organizationId);
        return repo.findByOrganization(organizationId);
    }
}
