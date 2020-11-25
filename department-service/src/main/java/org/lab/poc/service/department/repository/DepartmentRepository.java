package org.lab.poc.service.department.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.lab.poc.service.department.model.Department;

public class DepartmentRepository {
    
    private List<Department> departmentList = new ArrayList<>();

    public Department add(Department department) {
        department.setId((long)(departmentList.size()+1));
        departmentList.add(department);
        return department;
    }

    public List<Department> findAll() {
        return departmentList;
    }

    public Department findById(Long id) {
        Optional<Department> department = departmentList.stream().filter(dep -> dep.getId().equals(id)).findFirst();
        return department.isPresent() ? department.get() : null;
    }

    public List<Department> findByOrganization(Long organizationId) {
        return departmentList.stream().filter(dep -> dep.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
    }
}
