package com.rishabh.departments.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DepartmentRequest(
    @NotNull(message = "Department should be present")
    @NotEmpty(message = "Department should be present")
    @NotBlank(message = "Department should be present")
    @JsonProperty("department_name")
    String departmentName
){
}
