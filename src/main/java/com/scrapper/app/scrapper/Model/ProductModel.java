package com.scrapper.app.scrapper.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class ProductModel {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long Id;

    @Column(name =  "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private String price;

    @Column(name = "imageUrl")
    private String imageUrl;    

    public ProductModel() {
    }

    public ProductModel(Long id, String name, String brand, String price, String imageUrl) {
        Id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
