package com.revature.model;

import java.util.Scanner;

public class Manager {
    
    private String mngid;
    private String mngPw;
    private String mngEmail;

    Scanner s2;
    
   

    public Manager(Scanner s1){
        Scanner s2 = s1;
    }


    public void setManager(){
        System.out.println("Enter ID :");
        
        mngid = s2.nextLine();

        System.out.println("Enter email :");
        mngEmail = s2.nextLine();

        System.out.println("Enter Pw");
        mngPw = s2.nextLine();

       
    }
    public void display(){
        System.out.println("ID =  " + mngid);
        System.out.println("Email =" +mngEmail );
        System.out.println("Email =" + mngEmail);

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
    
    

    


