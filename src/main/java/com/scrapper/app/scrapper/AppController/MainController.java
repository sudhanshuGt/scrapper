package com.scrapper.app.scrapper.AppController;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.scrapper.app.scrapper.services.ProductService;
import com.scrapper.app.scrapper.Model.ProductModel;


@RestController
public class MainController {

    
    private final ProductService productService;

    


    public MainController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public List<ProductModel> findAllProduct(){
        return productService.findAllProduct();
    } 
    

    @GetMapping("/find/{id}")
    public Optional<ProductModel> findProductById(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @PostMapping("/save")
    public String saveProduct(@RequestBody ProductModel productModel) {
        String response = "";
        if (productModel.getBrand().isBlank() || productModel.getImageUrl().isBlank() || 
            productModel.getPrice().isBlank()) {
            response += "Data can't be empty";
        } else {
            response += "Item saved!";
            productService.saveProduct(productModel);
        }
        return response;
    }
    

    @PutMapping("/update")
    public ProductModel updaProduct(@RequestBody ProductModel productModel){
        return productService.saveProduct(productModel);
    }
   

    @DeleteMapping("/delete")
    public void deleteProduct(){
        productService.deleteAll();;
    }


    
}
