package com.csi.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;

    private String empName;

    private String empAddress;

    private double empSalary;

    @Column(unique = true)
    private long empContactNumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;

    @Column(unique = true)
    private String empEmailId;

    private String empPassword;
}
