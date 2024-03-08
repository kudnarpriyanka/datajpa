package com.csi.validation.service;

import com.csi.validation.model.Employee;
import com.csi.validation.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeRepo employeeRepoImpl;

    public Employee signUp(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public Optional<Employee> findById(int empId) {
        return employeeRepoImpl.findById(empId);
    }

    public List<Employee> findByName(String empFirstName) {
        return employeeRepoImpl.findByEmpFirstName(empFirstName);
    }

    public boolean signIn(String empEmailId, String empPassword) {
        boolean flag = false;

        Employee employee = employeeRepoImpl.findByEmpEmailIdAndEmpPassword(empEmailId, empPassword);

        if (employee != null && employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
            flag = true;
        }

        return flag;
    }

    public List<Employee> findAll() {
        return employeeRepoImpl.findAll();
    }

    public Employee update(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public void deleteById(int empId) {
        employeeRepoImpl.deleteById(empId);
    }
}