package com.example.ecommerce.dto;

public class ProductRequestDTO {
    
     private String name;
    private String description;
    private Double price;
    private String imgURL;

    public ProductRequestDTO() {
    }   

    public ProductRequestDTO(String name, String description, Double price, String imgURL) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgURL = imgURL;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgURL() {
        return imgURL;
    }

}
