package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.repository.EmployeeRepository;
import com.revature.service.EmployeeService;

import org.junit.jupiter.api.Test;

/*
    Mocking is when you replace a real class into something that isn't real and usually returns a hardcoded value
    Why do this? This guarantees that the class we depend on will always work
*/

public class ServiceTest {
    
    @Test
    public void Get_All_Employee_Should_Give_All_Employee()
    {
        //Arrange
        EmployeeRepository mockempRepo = Mockito.mock(EmployeeRepository.class);
        EmployeeService empServ = new EmployeeService(mockempRepo);

        //Telling Mockito to guarantee that if a specific method was called in our mock object, go ahead return hardcoded value
        List<Employee> expectedListOfEmployee = new ArrayList<>();
        expectedListOfEmployee.add(new Employee());
        expectedListOfEmployee.add(new Employee());
        expectedListOfEmployee.add(new Employee());

        Mockito.when(mockempRepo.getAllEmployee()).thenReturn(expectedListOfEmployee);

        //Act
        String jsonListEmployee = empServ.getAllEmployee();

        //Assert
        assertNotEquals("null", jsonListEmployee);
    }
}