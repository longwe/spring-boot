package com.mlongwe.springbootrest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mlongwe.springbootrest.domain.Product;

/**
 *  @author mlongwe
 */
public class ProductRepositoryImpl implements ProductRepositoryCustom {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Product> findBySkuOnlyAvailablesCustom(String sku) {
        Criteria criteria = Criteria.where("sku").is(sku).andOperator(Criteria.where("availability").is(1));
        return mongoTemplate.find(Query.query(criteria), Product.class);
    }
}
