package guru.springframework.blog.monetarycalculations;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class BigDecimalCalc {

    public void calculate(String param1, String param2){
        System.out.println("--------------------calculate-----------------------");
        BigDecimal num1=new BigDecimal(param1);
        BigDecimal num2=new BigDecimal(param2);
        System.out.println("num1: "+num1+" num2: "+ num2);
        System.out.println("BigDecimal Addition: "+num1.add(num2));
        System.out.println("BigDecimal Subtraction: " + num1.subtract(num2));
        System.out.println("BigDecimal Multiplication: "+num1.multiply(num2));
    }


    public  void divideWithScaleRounding(String param1, String param2){
        System.out.println("--------------------divisionWithScaleRounding-----------------------");

        /*Setting scale and rounding mode for division using overloaded divide(BigDecimal divisor, int scale, RoundingMode roundingMode) */
        BigDecimal num1=new BigDecimal(param1);
        BigDecimal num2=new BigDecimal(param2);
        System.out.println("num1: "+num1+" num2: "+ num2);
        System.out.println("BigDecimal Division with overloaded divide(): " + num1.divide(num2, 4, RoundingMode.HALF_EVEN));
    }

    public void calculateTax(String amount, String tax){
        System.out.println("--------------------calculateTax-----------------------");
        BigDecimal bdAmount = new BigDecimal(amount);
        BigDecimal bdTax = new BigDecimal(tax);
        BigDecimal taxAmount = bdAmount.multiply(bdTax);
        /*Setting scale and rounding mode using setScale() */
        taxAmount = taxAmount.setScale(2, RoundingMode.HALF_UP);
        BigDecimal finalAmount = bdAmount.add(taxAmount);
        finalAmount = finalAmount.setScale(2, RoundingMode.HALF_UP);

        System.out.println("Amount : " + bdAmount);
        System.out.println("Tax : " + taxAmount);
        System.out.println("Amount after tax: " + finalAmount);

    }
}
