package com.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Entity
@Table(name = "users")
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter
@Data
public class User implements Serializable {

    @Id
    @Indexed
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    private String departmentId;

}
