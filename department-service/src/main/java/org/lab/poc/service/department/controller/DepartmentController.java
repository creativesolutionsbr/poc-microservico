package org.lab.poc.service.department.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.lab.poc.service.department.client.EmployeeClient;
import org.lab.poc.service.department.model.Department;
import org.lab.poc.service.department.repository.DepartmentRepository;

@RestController
@OpenAPIDefinition(
    info = @Info(title = "Department API", version = "1.0", description = "Documentation Department API v1.0")
)
public class DepartmentController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    private EmployeeClient client;
    private DepartmentRepository repo;

    public DepartmentController(EmployeeClient client, DepartmentRepository repo) {
        this.client = client;
        this.repo = repo;
    }

    @PostMapping("/")
    public Department addDepartment(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return repo.add(department);
    }

    @GetMapping("/")
    public List<Department> findAll() {
        LOGGER.info("Department findAll");
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) {
        LOGGER.info("Department find: id={}", id);
        return repo.findById(id);
    }

    @GetMapping("/organization/{organizationId}")
    public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Department find: organizationId={}", organizationId);
        return repo.findByOrganization(organizationId);
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Department find: organizationId={}", organizationId);
        List<Department> departments = repo.findByOrganization(organizationId);
        departments.forEach(d -> d.setEmplyeeList(client.findByDepartment(d.getId())));
        return departments;
    }
}
