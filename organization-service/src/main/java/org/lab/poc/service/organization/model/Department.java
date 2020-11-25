package org.lab.poc.service.organization.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private Long id;
    private String name;
    private List<Employee> emplyeeList = new ArrayList<>();

    public Department() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Department [id=" + id +  ", name=" + name + "]";
    }
    
}
