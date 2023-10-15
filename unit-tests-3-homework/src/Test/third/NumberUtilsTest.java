package Test.third;
import org.junit.Test;
import seminars.third.hw.NumberUtils;

import static org.junit.Assert.assertEquals;

public class NumberUtilsTest {
    @Test
    public void testEvenNumber() {
        NumberUtils numberUtils = new NumberUtils();
        boolean result = numberUtils.evenOddNumber(4);
        assertEquals(true, result);
    }


    @Test
    public void testOddNumber() {
        NumberUtils numberUtils = new NumberUtils();
        boolean result = numberUtils.evenOddNumber(7);
        assertEquals(false, result);
    }

    @Test
    public void testNumberInInterval() {
        NumberUtils numberUtils = new NumberUtils();

        // Проверка чисел, которые попадают в интервал (25;100)
        assertEquals(true, numberUtils.numberInInterval(26));
        assertEquals(true, numberUtils.numberInInterval(50));
        assertEquals(true, numberUtils.numberInInterval(99));

        // Проверка чисел, которые не попадают в интервал (25;100)
        assertEquals(false, numberUtils.numberInInterval(10));
        assertEquals(false, numberUtils.numberInInterval(25));
        assertEquals(false, numberUtils.numberInInterval(1000));
    }
}
