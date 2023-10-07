/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;


/**
 *
 * @author Raiku
 */
public class OrderTable {
    private int orderId;
    private String shipName;
    private String shipMail;
    private String shipPhone;
    private String shipAddress;
    private Date orderDate;
    private int shipFee;
    private Discount discount;
    private float totalAmount;
    private String paymentMethod;
    private String status;
    private User user;
    
    public OrderTable() {
    }
    
    public OrderTable(String shipName, String shipMail, String shipPhone, String shipAddress, Date orderDate,
                 int shipFee, Discount discount, float totalAmount, String paymentMethod, String status, User user) {
        this.shipName = shipName;
        this.shipMail = shipMail;
        this.shipPhone = shipPhone;
        this.shipAddress = shipAddress;
        this.orderDate = orderDate;
        this.shipFee = shipFee;
        this.discount = discount;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.user = user;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipMail() {
        return shipMail;
    }

    public void setShipMail(String shipMail) {
        this.shipMail = shipMail;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getShipFee() {
        return shipFee;
    }

    public void setShipFee(int shipFee) {
        this.shipFee = shipFee;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    

    @Override
    public String toString() {
        return "dto.OrderTable[ orderId=" + orderId + " ]";
    }
    
}
