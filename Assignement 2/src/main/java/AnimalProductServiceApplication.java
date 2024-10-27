package com.example;

import com.example.service.AnimalProductService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class AnimalProductServiceApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new AnimalProductService(new AnimalProductRepository()))
                .build()
                .start();

        System.out.println("Server started on port 8080");
        server.awaitTermination();
    }
}
