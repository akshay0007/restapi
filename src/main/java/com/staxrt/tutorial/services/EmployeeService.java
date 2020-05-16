package com.staxrt.tutorial.services;

import com.staxrt.tutorial.daos.CustomDao;
import com.staxrt.tutorial.daos.EmployeeCrudDao;
import com.staxrt.tutorial.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeCrudDao employeeCrudDao;

    CustomDao customDao;

    public EmployeeService(EmployeeCrudDao employeeCrudDao, @Qualifier("employeeCrudDaoImpl") CustomDao customDao) {
        this.employeeCrudDao = employeeCrudDao;
        this.customDao = customDao;
    }

    public Optional<Employee> findById(String userId) {
        return employeeCrudDao.findById(userId);
    }

    public Employee save(Employee employee) {
        return employeeCrudDao.save(employee);
    }

    public void delete(Employee employee) {
        employeeCrudDao.delete(employee);
    }

    public Optional<Employee> update(Employee employee, String id) {
        return customDao.update(employee, id);
    }

}
