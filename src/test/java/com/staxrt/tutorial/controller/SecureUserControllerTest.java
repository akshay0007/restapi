package com.staxrt.tutorial.controller;


import com.staxrt.tutorial.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by ubuntu on 18/05/20.
 */
@ExtendWith(MockitoExtension.class)
public class SecureUserControllerTest {
    @InjectMocks
    SecureUserController secureUserController;

    @Mock
    private EmployeeService employeeService;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(secureUserController)
                .build();

    }

    public void tearDown() throws Exception {

    }

    public void getAllF() throws Exception {

    }

    public void getAll() throws Exception {

    }

    public void create() throws Exception {

    }

    public void findOne() throws Exception {

    }

}