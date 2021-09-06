package com.unacademy.cartService.services;

import com.unacademy.cartService.Exception.CartNotFoundException;
import com.unacademy.cartService.Exception.CustomerNameNotFoundException;
import com.unacademy.cartService.entities.Cart;

/**
 * We will define all the methods, that we want CartService to support
 */

public interface CartService {
    /**
     * Thos method will add new Cart and persist in the DB
     * @param cart
     * @return
     */
    public Cart createCart(Cart cart);
    public  boolean deleteCart (int cartID);
    public Cart findByCartId(int cartId) throws CartNotFoundException;
    public Cart findByCustomerName(String customerName) throws CustomerNameNotFoundException;
}
