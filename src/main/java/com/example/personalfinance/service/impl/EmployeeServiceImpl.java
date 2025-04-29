package com.example.personalfinance.service.impl;

import com.example.personalfinance.model.Employee;
import com.example.personalfinance.repository.EmployeeRepository;
import com.example.personalfinance.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository empRepo;

    @Override
    public List<Employee> getAllEmployee() {
        return empRepo.findAll();
    }

    @Override
    public void save(Employee employee) {
        empRepo.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        Optional<Employee> optional = empRepo.findById(id);
        Employee employee = null;
        if (optional.isPresent())
            employee = optional.get();
        else
            throw new RuntimeException(
                    "Employee not found for id : " + id);
        return employee;
    }

    @Override
    public void deleteViaId(long id) {
        empRepo.deleteById(id);
    }
}
