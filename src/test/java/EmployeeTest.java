import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest {

    @Test
    public void employeeNameTest(){
        Employee emp = new Employee();
        emp.setName("Evita");
        Assert.assertEquals(emp.getName(), "Evita");
    }

    @Test
    public void employeeSurnameTest(){
        Employee emp = new Employee();
        emp.setSurname("Savicka");
        Assert.assertEquals(emp.getSurname(), "Savicka");
    }

    @Test
    public void employeeYearTest(){
        Employee emp = new Employee();
        emp.setYear(30);
        Assert.assertEquals(emp.getYear(), 30);
    }
    @Test
    public void employeeRoleTest(){
        Employee emp = new Employee();
        emp.setRole("QA engineer");
        Assert.assertEquals(emp.getRole(), "QA engineer");
    }

    @Test
    public void testAllArguments(){
        Employee emp = new Employee("Evita", "Savicka", 30, "QA engineer");
        Assert.assertEquals(emp.getName(), "Evita");
        Assert.assertEquals(emp.getSurname(), "Savicka");
        Assert.assertEquals(emp.getYear(), 30);
        Assert.assertEquals(emp.getRole(), "QA engineer");
    }
}
