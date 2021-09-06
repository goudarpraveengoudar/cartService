package com.unacademy.cartService.daos;

import com.unacademy.cartService.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * This will be used to do the crud operation with the database
 */
public interface ItemDao extends JpaRepository<Item,Integer> {

}
