package mavenTestNGHomework;

import Calculator.CalculatorHomework;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorHWTest {


    @BeforeMethod(alwaysRun = true)
    public void startTest() {
        System.out.printf("Tests ir sācies!");
    }

    @AfterTest(alwaysRun = true)
    public void testFinish() {
        System.out.println("Testi ir pabeigti!");
    }

    @Test
    public void testAddMethod() {
        CalculatorHomework calculator = new CalculatorHomework();
        Assert.assertEquals(calculator.add(10, 20), 30);
    }

    @Test
    public void testSubtractMethod() {
        CalculatorHomework calculator = new CalculatorHomework();
        Assert.assertEquals(calculator.subtract(20, 10), 10);
    }

    @Test
    public void testMultiplyMethod() {
        CalculatorHomework calculator = new CalculatorHomework();
        Assert.assertEquals(calculator.multiply(10, 2), 20);
    }

    @Test
    public void testDivideMethod() {
        CalculatorHomework calculator = new CalculatorHomework();
        Assert.assertEquals(calculator.divide(20, 2), 10);
    }
}
