package com.example.testapi.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;



@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employment")
public class Employment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false)
    private Employee employee;

    @Column(name="position")
    private String position;

    @Column(name="department")
    private String department;

    @Column(name="employment_type")
    private String employmentType;

    @Column(name="employment_start")
    private LocalDate employmentStart;

    @Column(name="employment_end")
    private LocalDate employmentEnd;
}
