package com.revature.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.utils.ConnectionUtil;

/*
    Repository layer is responsible for interacting with a database and sending/receiving information from the database
*/
public class EmployeeRepository {
    //Create a method in PokemonRepository that allows you to store in a file locally in your computer
    public void Save(Employee employee)
    {
        
        String sql = "insert into employee (empname, empid, empEmail, ticket) values (?, ?, ?, ?)";
        //JDBC API
        try (Connection con = ConnectionUtil.getConnection()) {

            PreparedStatement prstmt = con.prepareStatement(sql);

            //We are replacing the '?' into actual values from the employee we received
            //Sadly, it uses one-based indexing so 1 is the very first parameter
            prstmt.setString(1, Employee.getempname());
            prstmt.setInt(2, Employee.getempId());
            prstmt.setString(3, Employee.getempEmail());
            prstmt.setInt(4, Employee.getTicket());
            

            //execute() method does not expect to return anything from the statement
            //executeQuery() method does expect something to result after executing the statement
            prstmt.execute();
            

        } 
        catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

    }

    public List<Employee> getAllEmployee() {
        String sql = "select * from Employee";
        List<Employee> listOfEmployee = new ArrayList<Employee>();
        try (Connection con = ConnectionUtil.getConnection()) {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            //Mapping information from a table to a DS instead
            while (rs.next()) {
                Employee newEmployee = new Employee();

                newEmployee.setName(rs.getString(2));
                newEmployee.setEmpId(rs.getInt(1));
                newEmployee.setEmail(rs.getString(3));
                newEmployee.setTicket(rs.getInt(4));
                

                newEmployee.setAbilities(getAbilityByEmpId(newEmployee.getEmpId()));

                listOfEmployee.add(newEmployee);
            }

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        return listOfEmployee;
    }

    

    private List<Ability> getAbilityByEmpId(int Empid)
    {
        //Implementation details
        //SQL statement that can grab all abilities for that specific employee
        
        return new ArrayList<>();
    }

}