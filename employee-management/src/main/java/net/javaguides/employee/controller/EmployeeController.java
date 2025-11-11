package net.javaguides.employee.controller;

import net.javaguides.employee.dto.EmployeeDto;
import net.javaguides.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class EmployeeController {

    private EmployeeService employeeService;

    // @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/{departmentId}/employees")
    public ResponseEntity<EmployeeDto> addEmployee(@PathVariable Long departmentId,
                                                   @RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.addEmployee(departmentId, employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{departmentId}/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long departmentId,
                                                       @PathVariable("id") Long employeeId){
          EmployeeDto employeeDto = employeeService.getEmployeeById(departmentId, employeeId);
          return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @GetMapping("/{departmentId}/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesByDepartmentId(@PathVariable Long departmentId) {
        List<EmployeeDto> employees = employeeService.getAllEmployeesByDepartmentId(departmentId);
//        return new ResponseEntity<>(employees, HttpStatus.OK);
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/{departmentId}/employees/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long departmentId,
                                                      @PathVariable Long employeeId,
                                                      @RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedEmployee = employeeService.updateEmployee(departmentId, employeeId, employeeDto);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{departmentId}/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long departmentId,
                                                 @PathVariable Long employeeId){
        employeeService.deleteEmployee(departmentId, employeeId);
        return ResponseEntity.ok("Employee deleted successfully!");
    }
}
