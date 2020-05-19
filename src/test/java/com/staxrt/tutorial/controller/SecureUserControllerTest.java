package com.staxrt.tutorial.controller;


import com.staxrt.tutorial.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
        mockMvc.perform(get("/abc"))
                .andExpect(status().isOk());

    }

    public void create() throws Exception {
        mockMvc.perform(post("/create")
                .param("shippingAddress.zipCode", "zipcode")
                .param("email", "email")
                .param("phoneNumber", "phoneno"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:customer/show/1"));
    }

    public void findOne() throws Exception {

    }

}