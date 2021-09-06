package com.unacademy.cartService.entities;

import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.persistence.*;
import java.util.List;

/**
 * Use this class to create tables in the Database
 */
    @Entity
    public class Cart {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int cartId;

        @Column(nullable = false, unique = true)
        private String customerName;

        @OneToMany(mappedBy = "cart")
        private List<Item> items ;

        public int getCartId() {
            return cartId;
        }

        public void setCartId(int cartId) {
            this.cartId = cartId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }
    }



