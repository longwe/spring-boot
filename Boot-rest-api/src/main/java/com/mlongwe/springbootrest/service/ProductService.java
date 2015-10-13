package com.mlongwe.springbootrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlongwe.springbootrest.domain.Product;
import com.mlongwe.springbootrest.repository.ProductRepository;

/**
 * Created with IntelliJ IDEA.
 * User: sezin karli
 * Date: 24.05.2014
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getSku(String sku){
        return repository.findBySku(sku);
    }

    public List<Product> getAvailableSku(String sku){
        return repository.findBySkuOnlyAvailables(sku);
    }

    public List<Product> getAvailableSkuCustom(String sku){
        return repository.findBySkuOnlyAvailablesCustom(sku);
    }
}
