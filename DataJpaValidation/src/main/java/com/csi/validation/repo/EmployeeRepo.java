package com.csi.validation.repo;


import com.csi.validation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    List<Employee> findByEmpFirstName(String empFirstName);

    Employee findByEmpEmailIdAndEmpPassword(String empEmailId, String empPassword);
}
