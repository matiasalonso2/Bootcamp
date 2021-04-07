package com.desafiospring.dto;

public class ProductDTO {

    private String productId;
    private String name;
    private String category;
    private String brand;
    private String price;
    private String quantity;
    private String freeShipping;
    private String prestige;

    public ProductDTO(String productId, String name, String category, String brand, String price, String quantity, String freeShipping, String prestige) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.freeShipping = freeShipping;
        this.prestige = prestige;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setFreeShipping(String freeShipping) {
        this.freeShipping = freeShipping;
    }

    public void setPrestige(String prestige) {
        this.prestige = prestige;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getFreeShipping() {
        return freeShipping;
    }

    public String getPrestige() {
        return prestige;
    }
}
