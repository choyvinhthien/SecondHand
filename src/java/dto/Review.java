/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

public class Review {
    private int reviewId;
    private float rating;
    private String comment;
    private Date date;
    private User user;
    private Product product;
    
    public Review() {
    }
    
    public Review(float rating, String comment, Date date, User user, Product product) {
        this.rating = rating;
        this.comment = comment;
        this.date=date;
        this.user = user;
        this.product = product;
    }

    public Review(int reviewId, float rating, String comment, Date date, User user, Product product) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
        this.user = user;
        this.product = product;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "dto.Review[ reviewId=" + reviewId + " ]";
    }
    
}
