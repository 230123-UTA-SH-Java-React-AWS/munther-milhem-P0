package com.revature.controllers;
import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class ManagerController implements HttpHandler{

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // TODO Auto-generated method stub
        String method = exchange.getRequestMethod();

        switch(method){
            case "POST":
            postRequest(exchange);
            break;
            
            default:
            String response = " try again, invalid input";
            exchange.sendResponseHeaders(404, method.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(method.getBytes()); 
            os.close();           
            
            break;
        }
        
    }

    private void postRequest(HttpExchange exchange)throws IOException {
    
    String response = " try again, invalid input";
            exchange.sendResponseHeaders(404, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes()); 
            os.close();           
    }        
}
