package net.javaguides.employee.service;

import net.javaguides.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto addEmployee(Long departmentId,
                            EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long departmentId, Long employeeId);

    List<EmployeeDto> getAllEmployeesByDepartmentId(Long departmentId);

    EmployeeDto updateEmployee(Long departmentId,
                               Long employeeId,
                               EmployeeDto employeeDto);

    void deleteEmployee(Long departmentId,
                        Long employeeId);
}
