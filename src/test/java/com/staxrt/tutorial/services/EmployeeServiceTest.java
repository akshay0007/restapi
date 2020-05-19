package com.staxrt.tutorial.services;


import com.staxrt.tutorial.daos.CustomDao;
import com.staxrt.tutorial.daos.EmployeeCrudDao;
import com.staxrt.tutorial.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by ubuntu on 18/05/20.
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    EmployeeCrudDao employeeCrudDao;

    @Mock
    CustomDao customDao;

    @InjectMocks
    EmployeeService employeeService;
    private Employee emp;
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeService)
                .build();
        emp = new Employee();
        emp.setName("abc");
        emp.setTitle("title");
    }

    @Test
    public void findById() throws Exception {
        when(employeeCrudDao.findById(anyString())).thenReturn(Optional.of(emp));
        Employee empA = employeeCrudDao.findById("abc").get();
        assertEquals(emp.getName(), empA.getName());
    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

}