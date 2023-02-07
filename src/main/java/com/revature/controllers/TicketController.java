package com.revature.controllers;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class TicketController implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String httpVerb = exchange.getRequestMethod();
        
        switch(httpVerb){
            case "GET":
            getRequest(exchange);
            break;
            default:
            String userName = " invalid user name, try again";
            exchange.sendResponseHeaders(404, userName.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(userName.getBytes());
            os.close();
            break;
        }
    }

    private void getRequest(HttpExchange exchange) throws IOException {
        String userName = " invalid user name, try again";
        
        exchange.sendResponseHeaders(200, userName.getBytes().length);
        
        OutputStream os = exchange.getResponseBody();
        os.write(userName.getBytes());
        os.close();
    }

    
    
}
