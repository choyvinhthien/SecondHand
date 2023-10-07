/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

public class OrderItem {
    private int orderItemId;
    private int quantity;
    private OrderTable orderTable;
    private Product product;
    
    public OrderItem() {
    }
    
    public OrderItem(int quantity, OrderTable orderTable, Product product) {
        this.quantity = quantity;
        this.orderTable = orderTable;
        this.product = product;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderTable getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(OrderTable orderTable) {
        this.orderTable = orderTable;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "dto.OrderItem[ orderItemId=" + orderItemId + " ]";
    }
    
}
