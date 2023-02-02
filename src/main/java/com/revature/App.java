package com.revature;
import com.revature.controllers.PokemonController;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Hello world!
 */
public final class App {
    
    public static void main(String[] args) throws Exception  {
        System.out.println("Stsrting backend server ");
        HttpServer server =  HttpServer.create(new InetSocketAddress(8000),0);

        server.createContext("/pokemon", new PokemonController());
        server.setExecutor(null);
        server.start();



    }

}
