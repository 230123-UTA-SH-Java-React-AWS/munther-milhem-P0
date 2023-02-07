package com.revature.model;
import java.util.Scanner;

public class Employee {
    private String empid;
    private String empPw;
    private String empEmail;

    Scanner s2;
    
   

    public Employee(Scanner s1){
        Scanner s2 = s1;
    }


    public Employee() {
    }


    public void setEmployee(){
        System.out.println("Enter ID :");
        
        empid = s2.nextLine();

        System.out.println("Enter email :");
        empEmail = s2.nextLine();

        System.out.println("Enter Pw");
        empPw = s2.nextLine();

       
    }
    public void display(){
        System.out.println("ID =  " + empid);
        System.out.println("Email =" +empEmail );
        System.out.println("Email =" + empEmail);

    }


    public int getEmpId() {
        return 0;
    }


    public void setAbilities(Object abilityByEmpId) {
    }


    


    public static int getempId() {
        return 0;
    }


    public static String getempEmail() {
        return 0;
    }


    public static int getTicket() {
        return 0;
    }


    

    public void setEmpId(int int1) {
    }


    public void setEmail(String st1) {
    }


    public void setTicket(int int1) {
    }


    public static String getempname() {
        return null;
    }


    public void setName(String string) {
    }


    public void setEmail(int int1) {
    }


    public static void postRequest(String string) {
    }
}
class main{
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        
        Employee obj = new Employee(s1);
        obj.setEmployee();
        obj.display();

    }
}
