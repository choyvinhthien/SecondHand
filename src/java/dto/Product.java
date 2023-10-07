/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.math.BigDecimal;

public class Product {
    private int productId;
    private String name;
    private BigDecimal price;
    private int quantity;
    private String description;
    private int quantitySold;
    private Category category;
    private User user;
    
    public Product() {
    }

    public Product(int productId, String name, BigDecimal price, int quantity, String description, int quantitySold, Category category, User user) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.quantitySold = quantitySold;
        this.category = category;
        this.user = user;
    }
    
    public Product(String name, BigDecimal price, int quantity, String description,int quantitySold, Category category, User user) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.quantitySold = quantitySold;
        this.category = category;
        this.user = user;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String toString() {
        return "dto.Product[ productId=" + productId + " ]";
    }
    
}
