public class Employee {

    //add fields
    //name, surname, year, role
    //all args constructor + no args constructor
    //getter/setter
    //test in under test/java package
    //goal: 100% coverage

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getYear() {
        return year;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Employee(String name, String surname, int year, String role) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.role = role;
    }

    public Employee() {
    }

    public String name;
    public String surname;
    public int year;
    public String role;
}
