package com.staxrt.tutorial.controller;

import com.staxrt.tutorial.exceptions.EmployeeNotFound;
import com.staxrt.tutorial.exceptions.ResourceNotFoundException;
import com.staxrt.tutorial.model.Employee;
import com.staxrt.tutorial.services.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/emp/{id}")
    @ApiOperation(value = "get employee by id",
            notes = "Also returns a link to retrieve all users with rel - all-users")
    public ResponseEntity<?> getEmpById(@PathVariable(value = "id") String userId) throws EmployeeNotFound {
        LOG.info("inside getEmployee");
        Employee employee = employeeService
                .findById(userId)
                .orElseThrow(() -> new EmployeeNotFound("Employee not found for :: " + userId));
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/emp")
    public ResponseEntity<?> createEmp(@Valid @RequestBody Employee emp, UriComponentsBuilder builder) throws ResourceNotFoundException {
        Employee employee = employeeService.save(emp);
        if (employee == null)
            throw new ResourceNotFoundException("Not able to store data");
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/emp/{id}")
                .buildAndExpand(employee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/emp/{id}")
    public ResponseEntity<?> updateEmp(@PathVariable(value = "id") String id,@Valid @RequestBody Employee empDetails) throws ResourceNotFoundException {
        Employee employee =  employeeService.update(empDetails,id)
               .orElseThrow(()->new ResourceNotFoundException("Not able to update employee"));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/emp/{id}")
    public ResponseEntity<?> deleteEmp(@PathVariable(value = "id") String empId) throws Exception {
        Employee emp = employeeService
                .findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found on :: " + empId));
        employeeService.delete(emp);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}