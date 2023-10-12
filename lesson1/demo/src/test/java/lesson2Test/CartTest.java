package lesson2Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


import lesson2.Cart;
import lesson2.Product;

public class CartTest {
    
     private Cart cart;
     private Product product1;
     private Product product2;

     @BeforeEach
     public void setUp() {
        cart = new Cart();
        product1 = new Product(1, "tomato", 1.2, 10);
        product2 = new Product(2, "apple", 5, 3);
    }

    @Test
    public void calculateTotalTest(){
        cart.addItem(product1);
        cart.addItem(product2);
        double expectedTotal = 25;
        double actualTotal = cart.calculateTotal();
        assertEquals(expectedTotal, actualTotal, "incorrect sum");
    }
}
