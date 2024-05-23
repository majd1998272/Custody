package com.example.demo.Repository;

import com.example.demo.Model.BatchItemsChangeStatus;
import com.example.demo.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees,String> {
    boolean existsByEmployeeId(String employeeId);
}

