package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.sound.sampled.SourceDataLine;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class PokemonController implements HttpHandler {

    @Override
    public void handle(HttpExchange arg0) throws IOException {
        // TODO Auto-generated method stub
        String verb = arg0.getRequestMethod();
        
        switch(verb){
            case "PUT":

               break;

            default:
               break;
        }
    }
    /**
     * @param arg0
     * @throws IOException
     */
    private void postRequest(HttpExchange arg0) throws IOException{
        InputStream is = arg0.getRequestBody();
        StringBuilder textBuilder = new StringBuilder();

        try(Reader reader =new  BufferedReader(new InputStreamReader(is, Charset.forName(StandardCharsets.UTF_8.name())))) {
           
            int c = 0 ;

            while((c = reader.read()) != -1){
                textBuilder.append((char)c);
            }

        }
        System.out.println(textBuilder.toString());
    }
    
    
}
