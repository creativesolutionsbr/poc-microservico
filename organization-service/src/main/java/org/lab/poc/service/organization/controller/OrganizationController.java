package org.lab.poc.service.organization.controller;

import java.util.List;

import org.lab.poc.service.organization.client.DepartmentClient;
import org.lab.poc.service.organization.client.EmployeeClient;
import org.lab.poc.service.organization.model.Organization;
import org.lab.poc.service.organization.repository.OrganizationRepository;
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
    info = @Info(title = "Organization API", version = "1.0", description = "Documentation Organization API v1.0")
)
public class OrganizationController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    private EmployeeClient employeeClient;
    private DepartmentClient departmentClient;
    private OrganizationRepository repo;

    public OrganizationController(EmployeeClient employeeClient, DepartmentClient departmentClient, OrganizationRepository repo) {
        this.employeeClient = employeeClient;
        this.departmentClient = departmentClient;
        this.repo = repo;
    }

    @PostMapping
    public Organization addOrganization(@RequestBody Organization organization) {
        LOGGER.info("Organization add: {}", organization);
        return repo.add(organization);
    }

    @GetMapping
    public List<Organization> findAll() {
        LOGGER.info("Organization find");
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable("id") Long id) {
        LOGGER.info("Organization find: id={}", id);
        return repo.findById(id);
    }

    @GetMapping("/{id}/with-departments")
    public Organization findByIdWithDepartments(@PathVariable("id") Long id) {
        LOGGER.info("Organization find: id={}", id);
        Organization organization = repo.findById(id);
        organization.setDepartments(departmentClient.findByOrganization(organization.getId()));
        return organization;
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {
        LOGGER.info("Organization find: id={}", id);
        Organization organization = repo.findById(id);
        organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId()));
        return organization;
    }

    @GetMapping("/{id}/with-employees")
    public Organization findByIdWithEmployees(@PathVariable("id") Long id) {
        LOGGER.info("Organization find: id={}", id);
        Organization organization = repo.findById(id);
        organization.setEmployees(employeeClient.findByOrganization(organization.getId()));
        return organization;
    }

}
