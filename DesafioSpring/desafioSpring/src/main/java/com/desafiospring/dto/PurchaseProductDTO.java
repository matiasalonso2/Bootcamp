package com.desafiospring.dto;

public class PurchaseProductDTO {
    private String productId;
    private String name;
    private String brand;
    private String quantity;

    public PurchaseProductDTO(String productId, String name, String brand, String quantity) {
        this.productId = productId;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
    }

    public PurchaseProductDTO() {
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getQuantity() {
        return quantity;
    }
}
