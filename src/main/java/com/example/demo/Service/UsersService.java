package com.example.demo.Service;

import com.example.demo.Repository.EmployeesRepository;
import com.example.demo.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private EmployeesRepository employeesRepository;
    public boolean isUserExists(String userId) {
        return userRepository.existsById(userId);
    }

    public boolean isEmployeeExist(String employeeId) {
        return employeesRepository.existsById(employeeId);
    }

}
