package com.unacademy.cartService.daos;

import com.unacademy.cartService.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This will be used to crud operation with database
 */
public interface CartDao extends JpaRepository<Cart, Integer> {

public Cart findByCustomerName(String name);




}
