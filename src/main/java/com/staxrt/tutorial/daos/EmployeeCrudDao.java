package com.staxrt.tutorial.daos;

import com.staxrt.tutorial.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface EmployeeCrudDao extends PagingAndSortingRepository<Employee, String> {
}