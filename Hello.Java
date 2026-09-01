// 1. ATM - Valid 4-Digit PIN
import java.util.*;

class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (pin >= 1000 && pin <= 9999)
            System.out.println("Valid PIN");
        else
            System.out.println("Invalid PIN");
    }
}

// 2. Library Fine
import java.util.*;

class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days late: ");
        int days = sc.nextInt();

        double fine;

        if (days <= 0)
            fine = 0;
        else if (days <= 5)
            fine = days * 2;
        else if (days <= 10)
            fine = days * 3;
        else
            fine = days * 5;

        System.out.println("Fine = " + fine);
    }
}


// 3. Company Tax Rate - static variable
class Q3 {
    static double taxRate = 18.0;

    public static void main(String[] args) {
        System.out.println("Tax Rate = " + taxRate + "%");

        taxRate = 20.0;

        System.out.println("Updated Tax Rate = " + taxRate + "%");
    }
}


/ 4. Transfer Money Between Accounts
class Q4 {
    double balance;

    Q4(double balance) {
        this.balance = balance;
    }

    void transfer(Q4 receiver, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            receiver.balance += amount;
            System.out.println("Transfer successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public static void main(String[] args) {
        Q4 account1 = new Q4(5000);
        Q4 account2 = new Q4(2000);

        account1.transfer(account2, 1500);

        System.out.println("Account 1: " + account1.balance);
        System.out.println("Account 2: " + account2.balance);
    }
}


// 5. Ride-Sharing App - Driver and Car
class Car {
    String model;

    Car(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car Model: " + model;
    }
}

class Driver {
    String name;
    Car car;

    Driver(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Driver: " + name + ", " + car;
    }
}
class Driver {
    String name;
    Car car;

    Driver(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Driver: " + name + ", " + car;
    }
}


// 6. E-Commerce - Method Overloading
class Q6 {

    double calculateTotal(double price, int quantity) {
        return price * quantity;
    }

    double calculateTotal(double price, int quantity, double discount) {
        return (price * quantity) - discount;
    }

    double calculateTotal(double price, int quantity, double discount, double tax) {
        double total = (price * quantity) - discount;
        return total + (total * tax / 100);
    }

    public static void main(String[] args) {
        Q6 obj = new Q6();

        System.out.println(obj.calculateTotal(100, 2));
        System.out.println(obj.calculateTotal(100, 2, 20));
        System.out.println(obj.calculateTotal(100, 2, 20, 18));
    }
}



// 7. Employee Salary - Instance and Static Methods
class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Instance-specific
    double calculateYearlySalary() {
        return salary * 12;
    }

    // Company-wide
    static double calculateYearlySalary(double monthlySalary) {
        return monthlySalary * 12;
    }

    public static void main(String[] args) {
        Employee e = new Employee("Alice", 50000);

        System.out.println("Instance Salary: " +
                e.calculateYearlySalary());

        System.out.println("Static Salary: " +
                Employee.calculateYearlySalary(50000));
    }
}




// 8. Form Validation with Exception Handling
import java.util.*;

class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter email: ");
            String email = sc.nextLine();

            System.out.print("Enter age: ");
            int age = sc.nextInt();

            if (email.length() < 18)
                throw new Exception("Email must contain at least 18 characters");

            if (age < 18)
                throw new Exception("Age must be at least 18");

            System.out.println("Form is valid");
        } catch (Exception e) {
            System.out.println("Invalid: " + e.getMessage());
        }
    }
}



// 9. Car with Nested Static Engine Class
class Q9 {

    static class Engine {
        String specification;

        Engine(String specification) {
            this.specification = specification;
        }

        void display() {
            System.out.println("Engine: " + specification);
        }
    }

    String model;
    Engine engine;

    Q9(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    void display() {
        System.out.println("Car: " + model);
        engine.display();
    }

    public static void main(String[] args) {
        Engine engine = new Engine("1.5L Petrol");
        Q9 car = new Q9("Honda City", engine);

        car.display();
    }
}




// 10. Access Modifiers
// File: package1/Employee.java
package package1;

public class Employee {
    public String publicField = "Public";
    protected String protectedField = "Protected";
    private String privateField = "Private";

    public void displayPrivate() {
        System.out.println(privateField);
    }
}
// File: package2/Manager.java
package package2;

import package1.Employee;

public class Manager extends Employee {
    public void display() {
        System.out.println(publicField);
        System.out.println(protectedField);

        // privateField cannot be accessed here
    }
}
// File: package2/Test.java
package package2;

import package1.Employee;

class Test {
    public static void main(String[] args) {
        Employee e = new Employee();

        System.out.println(e.publicField);

        // e.protectedField;  // Not accessible from another package
        // e.privateField;    // Not accessible

        e.displayPrivate();
    }
}




// 11. Login System - Encapsulation
class LoginSystem {
    private String password;

    LoginSystem(String password) {
        this.password = password;
    }

    public boolean checkPassword(String enteredPassword) {
        return password.equals(enteredPassword);
    }
}

class Q11 {
    public static void main(String[] args) {
        LoginSystem login = new LoginSystem("abc123");

        System.out.println(login.checkPassword("abc123"));
        System.out.println(login.checkPassword("wrong"));
    }
}





// 12. Employee Salary - Salary Can Only Increase
class Q12 {
    private double salary;

    Q12(double salary) {
        if (salary >= 0)
            this.salary = salary;
        else
            this.salary = 0;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double amount) {
        if (amount > 0) {
            salary += amount;
        }
    }

    public static void main(String[] args) {
        Q12 employee = new Q12(30000);

        employee.increaseSalary(5000);

        System.out.println("Salary: " + employee.getSalary());

        employee.increaseSalary(-3000);

        System.out.println("Salary: " + employee.getSalary());
    }
}
