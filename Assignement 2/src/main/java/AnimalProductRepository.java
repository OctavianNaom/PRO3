package com.example.repository;

import com.example.grpc.AnimalProductServiceProto.Animal;
import com.example.grpc.AnimalProductServiceProto.Product;

import java.util.List;

public class AnimalProductRepository {

    public List<Animal> findAnimalsByProduct(String productId) {
        return List.of();
    }

    public List<Product> findProductsByAnimal(String animalId) {
        return List.of();
    }
}
