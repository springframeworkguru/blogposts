package guru.springframework.blog.monetarycalculations;

import org.junit.Test;


public class BigDecimalCalcTest {

    @Test
    public void testCalculate() throws Exception {
        new BigDecimalCalc().calculate("4.0", "2.0");
    }

    @Test
    public void testDivideWithScaleRounding() throws Exception {
        new BigDecimalCalc().divideWithScaleRounding("2.5", "3.5");
    }

    @Test
    public void testCalculateTax() throws Exception {
        new BigDecimalCalc().calculateTax("10.00", ".0825");
    }
}