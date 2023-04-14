package com.scrapper.app.scrapper.services;



import java.util.List;
import java.util.Optional;

import com.scrapper.app.scrapper.Model.ProductModel;



public interface ProductService {
    List<ProductModel> findAllProduct();
    Optional<ProductModel> findById(Long id);
    ProductModel saveProduct(ProductModel productModel);
    ProductModel updatePriModel(ProductModel productModel);
    void deleteProduct(Long id);
    void deleteAll();
}
