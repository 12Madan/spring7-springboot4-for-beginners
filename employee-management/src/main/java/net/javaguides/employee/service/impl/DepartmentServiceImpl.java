package net.javaguides.employee.service.impl;

import net.javaguides.employee.dto.DepartmentDto;
import net.javaguides.employee.entity.Department;
import net.javaguides.employee.exception.ResourceNotFoundException;
import net.javaguides.employee.repository.DepartmentRepository;
import net.javaguides.employee.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    // @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository,
                                 ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DepartmentDto addDepartment(DepartmentDto departmentDto) {

        Department department = modelMapper.map(departmentDto, Department.class);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartment(Long id) {

        Department department = departmentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Department not found with id: " + id)
        );

        return modelMapper.map(department, DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {

        List<Department> departments = departmentRepository.findAll();

        return departments.stream()
                .map((department) -> modelMapper.map(department, DepartmentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto, Long id) {

         Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

         department.setDepartmentName(departmentDto.getDepartmentName());
         department.setDepartmentDescription(departmentDto.getDepartmentDescription());

         Department updatedDepartment = departmentRepository.save(department); // update

        return modelMapper.map(updatedDepartment, DepartmentDto.class);
    }

    @Override
    public void deleteDepartment(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

        departmentRepository.deleteById(id);
    }
}
