package com.revature.controllers;
import com.revature.service.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.instrument.Instrumentation;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import com.revature.model.Employee;
import com.revature.repository.EmployeeRepository;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class EmpController implements HttpHandler {


    



    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // TODO Auto-generated method stub
        String method = exchange.getRequestMethod(); 

        
        //Use switch statement to direct to specific private methods
        //use a nested switch statement that directs to a specific http verb

        switch (method) {
            case "POST":
                postRequest(exchange);
                break;
        
            default:
            String httpPass = " invalid password, try again";
            exchange.sendResponseHeaders(404, httpPass.getBytes().length);

            OutputStream os = exchange.getResponseBody();

            os.write(httpPass.getBytes());
            os.close();

            break;
        }

        System.out.println();
    }


    private void postRequest(HttpExchange exchange) throws IOException {
        
        //InputStream has a bunch of bytes
        InputStream is = exchange.getRequestBody();

        //We need to convert the InputStream into String
        //StringBuilder is like a mutable version of a String
        StringBuilder textBuilder = new StringBuilder();

        //Converts our binary into letters
        //try_resource block will automatically close the resource within the parenthesis
        
        try (Reader reader = new BufferedReader(new InputStreamReader(is, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;

            //read() method from BufferReader will give a -1 once there is no more letters left
            //TLDR keep reading each letter until there is no more left
            while ((c = reader.read()) != -1) {
                //Adds the letter to your text
                textBuilder.append((char)c);
            }
        } 

        

        exchange.sendResponseHeaders(200, textBuilder.toString().getBytes().length);

// calling the service layer and execute the method
       
        

        Employee.postRequest(textBuilder.toString());

        OutputStream os = exchange.getResponseBody();
        os.write(textBuilder.toString().getBytes());
        os.close();
    }


  



    

    

    
    
}