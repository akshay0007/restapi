package com.staxrt.tutorial.contextload;

import com.staxrt.tutorial.controller.SecureUserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by ubuntu on 10/06/20.
 */
@ExtendWith(MockitoExtension.class)
public class Controllerchecking {
    @InjectMocks
    SecureUserController secureUserController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(secureUserController)
                .build();

    }


}
