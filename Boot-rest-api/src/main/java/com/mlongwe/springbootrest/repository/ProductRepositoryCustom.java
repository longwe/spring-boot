package com.mlongwe.springbootrest.repository;

import java.util.List;
/**
@author mlongwe
*/
import com.mlongwe.springbootrest.domain.Product;

public interface ProductRepositoryCustom {
    public List<Product> findBySkuOnlyAvailablesCustom(String sku);
}
