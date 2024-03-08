package com.csi.validation.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Pattern(regexp="[A-Za-z]*", message="Emp First name should not contain space and special characters")
    private String empFirstName;

    @Size(min = 2, message = "Emp Last name should be atleast 2 character")
    private String empLastName;

    @NotNull
    private String empAddress;

    private double empSalary;

    @Range(min = 1000000000, max = 9999999999L, message = "Contact number must be 10 Digit")
    @Column(unique = true)
    private long empContactNumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;

    @Email(message = "Email must be valid")
    @Column(unique = true)
    private String empEmailId;

    @Size(min = 4, message = "Password should be atleast 4 character")
    private String empPassword;
}
