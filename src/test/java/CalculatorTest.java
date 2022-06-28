import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    @Test
    public void testAddMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(10.00, 20.00), 30.00);
    }

    @Test
    public void testSubtractMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.subtract(20.00, 10.00), 10.00, "Looks like method have some issues");
    }

    @Test
    public void testDivideMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(20.00, 10.00), 2.00);
    }

    @Test
    public void testMultiplyMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiply(20.00, 2.00), 40.00);
    }

}
