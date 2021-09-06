package com.unacademy.cartService.services.impl;

import com.unacademy.cartService.Exception.CartNotFoundException;
import com.unacademy.cartService.Exception.CustomerNameNotFoundException;
import com.unacademy.cartService.daos.CartDao;
import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;


    @Override
    public Cart createCart(Cart cart) {
        return cartDao.save(cart);
    }

    @Override
    public boolean deleteCart(int cartID) {
        cartDao.deleteById(cartID);
        return true;

    }

    @Override
    public Cart findByCartId(int cartId) throws CartNotFoundException {
        return cartDao.findById(cartId).orElseThrow(() -> new CartNotFoundException());
    }

    @Override
    public Cart findByCustomerName(String customerName) throws CustomerNameNotFoundException {


        Cart cart = cartDao.findByCustomerName(customerName);
        if (cart == null) {
            throw new CustomerNameNotFoundException();
        }
        return cart;
    }
    }
