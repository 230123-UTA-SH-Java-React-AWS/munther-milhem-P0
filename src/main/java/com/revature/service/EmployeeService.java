package com.revature.service;

import java.io.IOException;
import java.util.List;

import com.revature.model.Employee;
import com.revature.repository.EmployeeRepository;

/*
    The service layer is responsible for hold behavior driven classes
    It might have further validation or information process within the service
*/
public class EmployeeService {

    private final ObjectMapper mapper = new ObjectMapper();
    
    //The whole point of DI pattern is to force the supplement of the dependencies
    //=============== Dependency Injection =================
    //Create a constructor and add in the parameter the class dependency
    private final EmployeeRepository emprepo;

    public EmployeeService(EmployeeRepository emprepo) {
        this.emprepo = emprepo;
    }

    
    public void saveToEmpBox(String empJson)throws IOException
    {

        try {
            Employee newEmployee = mapper.readValue(empJson, Employee.class);
            emprepo.Save(newEmployee);

        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    //Converting List into 
    public String getAllEmployee()
    {
        List<Employee> listOfEmp = emprepo.getAllEmployee();
        String jsonString = "";

        try {
            jsonString = mapper.writeValueAsString(listOfEmp);

        
        } catch (IOException e) {
            
            e.printStackTrace();
        }

        return jsonString;
    }

    
}