/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Raiku
 */
public class ShoppingCart {
    private int cartId;
    private User user;
    
    public ShoppingCart() {
    }
    
    public ShoppingCart(User user) {
        this.user = user;
    }
    
    public int getCartId() {
        return cartId;
    }
    
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "dto.ShoppingCart[ cartId=" + cartId + " ]";
    }
    
}
