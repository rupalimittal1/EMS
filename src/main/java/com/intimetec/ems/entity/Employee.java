package com.intimetec.ems.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "e_id")
    private Long id;

    @Column(name = "e_name", nullable = false)
    private String name;

    @Column(name = "e_email", nullable = false)
    private String email;

    @Column(name = "active_status")
    private boolean activeStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "d_id", nullable = false)
    private Department department;
}
