package com.unacademy.cartService.services.impl;

import com.unacademy.cartService.Exception.CartNotFoundException;
import com.unacademy.cartService.Exception.CustomerNameNotFoundException;
import com.unacademy.cartService.daos.CartDao;
import com.unacademy.cartService.entities.Cart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;



import java.util.Optional;

@SpringBootTest
public class CartServiceImplTest {


    @Mock
    CartDao cartDaoMock;
    @InjectMocks
    CartServiceImpl cartService;
@Test
public void test(){
    System.out.println("cart Dao :"+ cartDaoMock);
    System.out.println("Cart service :"+ cartService);


}

/**
 * Test  for createCart
 */
@Test
public void testCreateCart(){
    // Create the data
    Cart cart =new Cart();
    cart.setCustomerName("Vishwa Mohan");

Cart cart1 =new Cart();
cart1.setCustomerName("Vishwa Mohan");
cart1.setCartId(1);

// Give the functionality to the mock
    Mockito.when(cartDaoMock.save(cart)).thenReturn(cart1);

//Execution
Cart savedCart = cartService.createCart(cart);


    //Testing
    Assertions.assertNotNull(savedCart);
    Assertions.assertEquals( 1, savedCart.getCartId());
}



/**
 * Test for deleteCart
 */

@Test
public void testDeleteCart(){

    //Data


//Not needed because we are planning to mock the db delete part
    //Mockup
// Mockito.doNothing(cartDaoMock.deleteById(1));

    //Execution


    //Testing
}

/**
 * Test for findByCartId
 */
@Test
public void testFindByCartId() throws CartNotFoundException {

    //Data
    Cart cart1 =new Cart();
    cart1.setCustomerName("Vishwa Mohan");
    cart1.setCartId(1);

    //Mock
Mockito.when(cartDaoMock.findById(1)).thenReturn(Optional.of(cart1));

    //Execution
Cart cart = cartService.findByCartId(1);
    //Testing
Assertions.assertNotNull(cart);
Assertions.assertEquals("Vishwa Mohan",cart.getCustomerName());
}
@Test
public void testFindCartIdThrowsExceptions() throws CartNotFoundException {

    //Data
    Cart cart1 = new Cart();
    cart1.setCustomerName("Vishwa Mohan");
    cart1.setCartId(1);

    //Mock
    Mockito.when(cartDaoMock.findById(1)).thenReturn(Optional.empty());

    //Execution
    try {
        Cart cart = cartService.findByCartId(1);


    } catch (Exception e) {
        Assertions.assertEquals(CartNotFoundException.class, e.getClass());
    }


}
    /**
     * Test for findByCustomerName
     */











    @Test
    public void testFIndByCustomerName() throws CustomerNameNotFoundException {
        Cart cart1 = new Cart();
cart1.setCustomerName("Vishwa Mohan");
cart1.setCartId(1);


Mockito.when(cartDaoMock.findByCustomerName("Vishwa Mohan")).thenReturn(cart1);

//execution
        Cart cart =cartService.findByCustomerName("Vishwa Mohan");

        //Assertion

        Assertions.assertNotNull(cart);
        Assertions.assertEquals("Vishwa Mohan", cart.getCustomerName());



    }


}
