package com.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String departmentName;

    private String departmentAddress;

    private String departmentCode;

}
