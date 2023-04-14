package com.scrapper.app.scrapper.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scrapper.app.scrapper.Model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long>  {
    
}
