/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

public class Discount {
    private int id;
    private String code;
    private int discountAmount;
    private float discountPercent;
    private Date validFrom;
    private Date validTo;
    
    public Discount() {
    }
    
    public Discount(String code, int discountAmount, float discountPercent, Date validFrom, Date validTo) {
        this.code = code;
        this.discountAmount = discountAmount;
        this.discountPercent = discountPercent;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public int getDiscountAmount() {
        return discountAmount;
    }
    
    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }
    
    public float getDiscountPercent() {
        return discountPercent;
    }
    
    public void setDiscountPercent(float discountPercent) {
        this.discountPercent = discountPercent;
    }
    
    public Date getValidFrom() {
        return validFrom;
    }
    
    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }
    
    public Date getValidTo() {
        return validTo;
    }
    
    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }


    @Override
    public String toString() {
        return "dto.Discount[ id=" + id + " ]";
    }
    
}
