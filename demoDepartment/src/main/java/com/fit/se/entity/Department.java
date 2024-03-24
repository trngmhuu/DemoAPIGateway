package com.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Entity
@Table(name = "departments")
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter
@Data
public class Department implements Serializable {

    @Id
    @Indexed
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
