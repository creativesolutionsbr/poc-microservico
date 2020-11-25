package org.lab.poc.service.employee.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.lab.poc.service.employee.model.Employee;

public class EmployeeRepository {
    
    private List<Employee> employeeList = new ArrayList<>();

    public Employee add(Employee employee) {
        employee.setId((long)(employeeList.size()+1));
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> findAll() {
        return employeeList;
    }

    public Employee findById(Long id) {
        Optional<Employee> employee = employeeList.stream().filter(emp -> emp.getId().equals(id)).findFirst();
        return employee.isPresent() ? employee.get() : null;
    }

    public List<Employee> findByDepartment(Long departmentId) {
        return employeeList.stream().filter(emp -> emp.getDepartmentId().equals(departmentId)).collect(Collectors.toList());
    }

    public List<Employee> findByOrganization(Long organizationId) {
        return employeeList.stream().filter(emp -> emp.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
    }
}
