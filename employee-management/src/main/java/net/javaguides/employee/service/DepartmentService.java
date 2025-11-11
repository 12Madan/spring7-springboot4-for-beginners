package net.javaguides.employee.service;

import net.javaguides.employee.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto addDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartment(Long id);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(DepartmentDto departmentDto, Long id);

    void deleteDepartment(Long id);
}
