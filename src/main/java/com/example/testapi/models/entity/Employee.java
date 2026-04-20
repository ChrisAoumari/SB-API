package com.example.testapi.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="father_name")
    private String fatherName;

    @Column(name="mother_name")
    private String motherName;

    @Column(name="afm")
    private Long afm;

    @Column(name="amka")
    private Long amka;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Column(name="child_num")
    private Integer childNum;

    @Column(name="marital_status")
    private String maritalStatus;

    @Column(name="education")
    private String education;

    @Column(name="active")
    private Boolean active;

}
