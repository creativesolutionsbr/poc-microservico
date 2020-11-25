package org.lab.poc.service.department.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private Long id;
    private Long organizationId;
    private String name;
    private List<Employee> emplyeeList = new ArrayList<>();

    public Department() {

    }

    public Department(Long organizationId, String name) {
        super();
        this.organizationId = organizationId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmplyeeList() {
        return emplyeeList;
    }

    public void setEmplyeeList(List<Employee> emplyeeList) {
        this.emplyeeList = emplyeeList;
    }

    @Override
    public String toString() {
        return "Department [id=" + id +  ", organizationId=" + organizationId + ", name=" + name + "]";
    }
    
}
