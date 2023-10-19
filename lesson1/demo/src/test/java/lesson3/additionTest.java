package lesson3;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;


public class additionTest {
    @Test
    public void testAddition() {
    Calculator calculator = new Calculator();
    int result = calculator.add(2, 3);
    assertEquals(5, result);
    }

    // @Test
    //     public void testAddDoesNotAcceptChar() {
    //     Calculator calculator = new Calculator();
    //     try {
    //         char invalidChar = 'a';
    //         int result = calculator.addition(2, invalidChar);
    //     } catch (IllegalArgumentException e) {
    //         assertThat(e.getMessage()).isEqualTo("Input must be an integer.");
    //     }
    // }

}

