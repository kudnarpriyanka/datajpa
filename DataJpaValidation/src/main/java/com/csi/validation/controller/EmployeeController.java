package com.csi.validation.controller;


import com.csi.validation.exception.RecordNotFoundException;
import com.csi.validation.model.Employee;
import com.csi.validation.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@Valid @RequestBody Employee employee) {
        return new  ResponseEntity<>(employeeServiceImpl.signUp(employee), HttpStatus.CREATED);
    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId, @PathVariable String empPassword) {
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId, empPassword));
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable int empId) {
        return ResponseEntity.ok(employeeServiceImpl.findById(empId));
    }

    @GetMapping("/findbyname/{empFirstName}")
    public ResponseEntity<List<Employee>> findByFirstName(@PathVariable String empFirstName) {
        return ResponseEntity.ok(employeeServiceImpl.findByName(empFirstName));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeServiceImpl.findAll());
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> updateData(@PathVariable int empId, @Valid @RequestBody Employee employee) {
        Employee employee1 = employeeServiceImpl.findById(empId).orElseThrow(() -> new RecordNotFoundException("Employee ID does Not Exist"));

        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpPassword(employee1.getEmpPassword());

        return new ResponseEntity<>(employeeServiceImpl.update(employee1), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletebyid/{empId}")
    public ResponseEntity<String> deleteById(@PathVariable int empId) {
        employeeServiceImpl.deleteById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }
}