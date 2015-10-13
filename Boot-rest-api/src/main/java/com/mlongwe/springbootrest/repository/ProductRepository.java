package com.mlongwe.springbootrest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mlongwe.springbootrest.domain.Product;
/**
@author mlongwe
*/

public interface ProductRepository extends MongoRepository<Product, String>, ProductRepositoryCustom {
    public List<Product> findBySku(String sku);

    @Query(value = "{sku: ?0, availability : 1}")
    public List<Product> findBySkuOnlyAvailables(String sku);
}
