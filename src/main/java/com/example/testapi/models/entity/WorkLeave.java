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
@Table(name = "work_leave")
public class WorkLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leave_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false)
    private Employee employee;

    @Column(name="leave_type")
    private String leaveType;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;
}
