package com.revature.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.revature.service.EmployeeService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class TicketController implements HttpHandler{
    
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String httpVerb = exchange.getRequestMethod();

        switch (httpVerb){
            case "POST":
                postRequest(exchange);
                break;
            case "GET":
                getRequest(exchange);
            default:
                //implementation details if accessing http verb not supported
                String someResponse = "HTTP verb not supported";

                exchange.sendResponseHeaders(404, someResponse.getBytes().length);

                OutputStream os = exchange.getResponseBody();
                os.write(someResponse.getBytes());
                os.close();
                break;
        }     
    }

    public void postRequest(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();

        StringBuilder textBuilder = new StringBuilder();
        try(Reader reader = new BufferedReader(new InputStreamReader(is, Charset.forName(StandardCharsets.UTF_8.name())))){
            int c = 0;

            while ((c = reader.read()) != -1){
                textBuilder.append((char)c);
            }
        }


        exchange.sendResponseHeaders(200, textBuilder.toString().getBytes().length);
        EmployeeService employService = new EmployeeService();
        employService.newTicket(textBuilder.toString());

        OutputStream os = exchange.getResponseBody();
        os.write(textBuilder.toString().getBytes());
        os.close();
    }

    public void getRequest(HttpExchange exchange) throws IOException{
        InputStream is = exchange.getRequestBody();

        StringBuilder textBuilder = new StringBuilder();
        try(Reader reader = new BufferedReader(new InputStreamReader(is, Charset.forName(StandardCharsets.UTF_8.name())))){
            int c = 0;

            while ((c = reader.read()) != -1){
                textBuilder.append((char)c);
            }
        }
        
        EmployeeService employeeService = new EmployeeService();
        //EmployeeService.prevTicket(textBuilder.toString());
        String jsonList = employeeService.prevTicket(textBuilder.toString());
        exchange.sendResponseHeaders(200, jsonList.getBytes().length);

        OutputStream os = exchange.getResponseBody();
        os.write(jsonList.toString().getBytes());
        os.close();
    }
}