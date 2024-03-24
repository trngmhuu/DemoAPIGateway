package com.fit.se.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto implements Serializable {

    private int id;
    private String departmentName;
    private String departmentAddress;

}
