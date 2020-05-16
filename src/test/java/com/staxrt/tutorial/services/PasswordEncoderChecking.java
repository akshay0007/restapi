package com.staxrt.tutorial.services;

import com.staxrt.tutorial.SecureUserControllerTest.SecureUserController;
import com.staxrt.tutorial.model.SecureUser;
import com.staxrt.tutorial.securities.EncryptionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


/**
 * Created by ubuntu on 16/05/20.
 */
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = SecureUserController.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PasswordEncoderChecking {

    private EncryptUserService encryptUserService;
    private MockMvc mockMvc;
    private PasswordEncoder passwordEncoder;
    private EncryptionService encryptionService;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Autowired
    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

//    @BeforeTestClass
//    public void init(){
//        this.encryptUserService=new EncryptUserService();
//        this.encryptionService=new EncryptionServiceImpl(passwordEncoder);
//        mockMvc = MockMvcBuilders.standaloneSetup(encryptUserService).build();
//    }

    @Test
    public void testPass() {
        SecureUser secureUser = encryptUserService.findByUserName("names");
        secureUser.getPassword();
        encryptionService.checkEncyptPassword(secureUser.getPassword(), secureUser.getEncryptedPass());
    }


//    @Test
//    public void testSaveOrUpdate() throws Exception {
//        Integer id = 1;
//        Customer returnCustomer = new Customer();
//        String firstName = "Micheal";
//        String lastName = "Weston";
//        String addressLine1 = "1 Main St";
//        String addressLine2 = "Apt 301";
//        String city = "Miami";
//        String state = "Florida";
//        String zipCode = "33101";
//        String email = "micheal@burnnotice.com";
//        String phoneNumber = "305.333.0101";
//        String username = "mweston";
//        String password = "password";
//
//        returnCustomer.setId(id);
//        returnCustomer.setFirstName(firstName);
//        returnCustomer.setLastName(lastName);
//        returnCustomer.setBillingAddress(new Address());
//        returnCustomer.getBillingAddress().setAddressLine1(addressLine1);
//        returnCustomer.getBillingAddress().setAddressLine2(addressLine2);
//        returnCustomer.getBillingAddress().setCity(city);
//        returnCustomer.getBillingAddress().setState(state);
//        returnCustomer.getBillingAddress().setZipCode(zipCode);
//        returnCustomer.setEmail(email);
//        returnCustomer.setPhoneNumber(phoneNumber);
//        returnCustomer.setUser(new User());
//        returnCustomer.getUser().setUsername(username);
//        returnCustomer.getUser().setPassword(password);
//
//        when(customerService.saveOrUpdateCustomerForm(Matchers.<CustomerForm>any())).thenReturn(returnCustomer);
//        when(customerService.getById(Matchers.<Integer>any())).thenReturn(returnCustomer);
//
//        mockMvc.perform(post("/customer")
//                .param("customerId", "1")
//                .param("firstName", firstName)
//                .param("lastName", lastName)
//                .param("userName", username)
//                .param("passwordText", password)
//                .param("passwordTextConf", password)
//                .param("shippingAddress.addressLine1", addressLine1)
//                .param("shippingAddress.addressLine2", addressLine2)
//                .param("shippingAddress.city", city)
//                .param("shippingAddress.state", state)
//                .param("shippingAddress.zipCode", zipCode)
//                .param("email", email)
//                .param("phoneNumber", phoneNumber))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:customer/show/1"));
//
//        ArgumentCaptor<CustomerForm> customerCaptor = ArgumentCaptor.forClass(CustomerForm.class);
//        verify(customerService).saveOrUpdateCustomerForm(customerCaptor.capture());
//
//        CustomerForm boundCustomer = customerCaptor.getValue();
//
//        assertEquals(id, boundCustomer.getCustomerId());
//        assertEquals(firstName, boundCustomer.getFirstName());
//        assertEquals(lastName, boundCustomer.getLastName());
//        assertEquals(email, boundCustomer.getEmail());
//        assertEquals(phoneNumber, boundCustomer.getPhoneNumber());
//
//    }

}
