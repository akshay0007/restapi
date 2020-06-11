package com.staxrt.tutorial.contextload;

import com.staxrt.tutorial.controller.SecureUserController;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by ubuntu on 10/06/20.
 */
public class MockController {
    @InjectMocks
    private SecureUserController secureUserController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

}
