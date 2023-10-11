package task4;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException; // Импорт метода assertThatIllegalArgumentException
import org.assertj.core.api.ThrowableAssert;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class calculatorTest {
    
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @BeforeAll
    public static void initAll() {
        System.out.printf("Hiii!!!!!");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.printf("END!");    }

    @AfterEach
    public void tearDown() {
        calculator = null; // Очистка после каждого теста
    }

    @Test
    @DisplayName("Проверка равенства значений")
    public void testAssertEquals() {
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    @DisplayName("Проверка неравенства значений")
    public void testAssertNotEquals() {
        assertNotEquals(5, calculator.add(2, 2));
    }

    @Test
    @DisplayName("Проверка истинного условия")
    public void testAssertTrue() {
        assertTrue(calculator.add(2, 2) == 4);
    }

    @Test
    @DisplayName("Проверка ложного условия")
    public void testAssertFalse() {
        assertFalse(calculator.add(2, 2) == 5);
    }

    @Test
    @DisplayName("Проверка наличия объекта")
    public void testAssertNotNull() {
        assertNotNull(calculator);
    }

    @Test
    @DisplayName("Проверка отсутствия объекта")
    public void testAssertNull() {
        calculator = null;
        assertNull(calculator);
    }

    @Test
    @DisplayName("Проверка равенства массивов")
    public void testAssertArrayEquals() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка на генерацию исключений")
    public void testAssertThrows() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 2));
    }

    // Дополнительные ассерты
    @Test
    @DisplayName("Проверка с сообщением")
    public void testAssertWithMessage() {
        assertEquals(4, calculator.add(2, 2), "2 + 2 должно быть равно 4");
    }

    @Test
    @DisplayName("Проверка с использованием лямбда-выражения для сообщения")
    public void testAssertWithLambdaMessage() {
        assertEquals(4, calculator.add(2, 2), () -> "2 + 2 должно быть равно 4");
    }



    @Test
    @DisplayName("Проверка метода calculateDiscount, на корректный рассчет сумму с учетом скидки для допустимых входных данных")
    public void testCalculateDiscountWithValidInput() {
        double purchaseAmount = 100.0;
        double discountPercentage = 10.0;
        double expectedDiscountedPrice = 90.0; // Ожидаемая сумма с учетом скидки

        double actualDiscountedPrice = Calculator.calculateDiscount(purchaseAmount, discountPercentage);

        assertThat(actualDiscountedPrice).isEqualTo(expectedDiscountedPrice);
    }


    @Test
    @DisplayName("Проверка метода calculateDiscount на выброс исключения, если сумма покупки равна нулю")
    public void testCalculateDiscountWithZeroPurchaseAmount() {
        double purchaseAmount = 0.0;
        double discountPercentage = 10.0;

        // Ожидается IllegalArgumentException, так как сумма покупки равна нулю
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculateDiscount(purchaseAmount, discountPercentage);
        });
    }


    @Test
    @DisplayName("Проверка метода calculateDiscount на выброс исключения, если процент скидки отрицательный")
    public void testCalculateDiscountWithNegativeDiscountPercentage() {
        double purchaseAmount = 100.0;
        double discountPercentage = -10.0;

        // Ожидается IllegalArgumentException, так как процент скидки отрицательный
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculateDiscount(purchaseAmount, discountPercentage);
        });
    }

    @Test
    @DisplayName("Проверка метода calculateDiscount на выброс исключения, если процент скидки больше 100")
    public void testCalculateDiscountWithDiscountPercentageGreaterThan100() {
        double purchaseAmount = 100.0;
        double discountPercentage = 110.0;

        // Ожидается IllegalArgumentException, так как процент скидки больше 100
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculateDiscount(purchaseAmount, discountPercentage);
        });
    }

}
