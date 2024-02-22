package com.csi.service;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
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

    public List<Employee> saveAll(List<Employee> employeeList) {
        return employeeRepoImpl.saveAll(employeeList);
    }

    public boolean signIn(String empEmailId, String empPassword) {
        boolean status = false;
        Employee employee = employeeRepoImpl.findByEmpEmailIdAndEmpPassword(empEmailId, empPassword);
        if (employee != null && employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
            status = true;
        }
        return status;
    }

    public List<Employee> findByName(String empName) {
        return employeeRepoImpl.findByEmpName(empName);
    }

    public Employee findByContactNumber(long empContactNumber) {
        return employeeRepoImpl.findByEmpContactNumber(empContactNumber);
    }

    public Optional<Employee> findById(long empId) {
        return employeeRepoImpl.findById(empId);
    }

    public List<Employee> findAll() {
        return employeeRepoImpl.findAll();
    }

    public Employee update(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public void deleteById(long empId) {
        employeeRepoImpl.deleteById(empId);
    }

    public void deleteAll() {
        employeeRepoImpl.deleteAll();
    }

    public Employee changeAddress(Employee employee) {

        return employeeRepoImpl.save(employee);
    }
}
