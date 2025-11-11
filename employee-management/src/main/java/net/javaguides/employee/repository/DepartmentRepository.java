package net.javaguides.employee.repository;

import net.javaguides.employee.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // CRUD operations
}
