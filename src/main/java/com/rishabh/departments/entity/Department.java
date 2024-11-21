package com.rishabh.departments.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long department_id;

    @Column(name = "department_name", nullable = false)
    private String department_name;

    @Column(name = "capacity")
    private int capacity=0;
}
