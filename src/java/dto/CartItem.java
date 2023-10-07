/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

public class CartItem {
    private int cartItemId;
    private int quantity;
    private Product product;
    private ShoppingCart cart;
    
    public CartItem() {
    }
    
    public CartItem(int quantity, Product product, ShoppingCart cart) {
        this.quantity = quantity;
        this.product = product;
        this.cart = cart;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "dto.CartItem[ cartItemId=" + cartItemId + " ]";
    }
    
}
