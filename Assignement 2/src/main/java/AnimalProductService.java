package com.example.service;

import com.example.grpc.AnimalProductServiceProto.*;
import io.grpc.stub.StreamObserver;

public class AnimalProductService extends AnimalProductServiceGrpc.AnimalProductServiceImplBase {

    private final AnimalProductRepository repository;

    public AnimalProductService(AnimalProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getAnimalByProduct(ProductRequest request, StreamObserver<AnimalResponse> responseObserver) {
        AnimalResponse response = AnimalResponse.newBuilder()
                .addAllAnimals(repository.findAnimalsByProduct(request.getProductId()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getProductsByAnimal(AnimalRequest request, StreamObserver<ProductResponse> responseObserver) {
        ProductResponse response = ProductResponse.newBuilder()
                .addAllProducts(repository.findProductsByAnimal(request.getAnimalId()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
