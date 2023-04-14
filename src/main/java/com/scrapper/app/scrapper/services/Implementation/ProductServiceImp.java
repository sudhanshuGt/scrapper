package com.scrapper.app.scrapper.services.Implementation;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scrapper.app.scrapper.Model.ProductModel;
import com.scrapper.app.scrapper.Repository.ProductRepository;
import com.scrapper.app.scrapper.services.ProductService;


@Service
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;

    


    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> findAllProduct() {
       return productRepository.findAll();
    }

    @Override
    public Optional<ProductModel> findById(Long id) {
        return productRepository.findById(id);
        
    }

    @Override
    public ProductModel saveProduct(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    @Override
    public ProductModel updatePriModel(ProductModel productModel) {
       return productRepository.save(productModel);
    }

    @Override
    public void deleteProduct(Long id) {
       productRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }
    
}
