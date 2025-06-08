package org.Java8_Example.StreamApi.Employee;

import java.util.Arrays;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private String city;
    private String country;
    private String departmentName;


    public Employee(int id, String name, double salary, String city, String country, String departmentName) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.city = city;
        this.country = country;
        this.departmentName = departmentName;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getCity() { return city; }
    public String getCountry() { return country; }
    public String getDepartmentName() { return departmentName; }


    public static List<Employee> getObject() {
        return Arrays.asList(
                new Employee(101, "Alice", 70000, "New York", "USA", "HR"),
                new Employee(102, "Bob", 80000, "Chicago", "USA", "Finance"),
                new Employee(103, "Charlie", 95000, "London", "UK", "Tech"),
                new Employee(104, "David", 60000, "New York", "USA", "Tech"),
                new Employee(105, "Eve", 85000, "Mumbai", "India", "Finance"),
                new Employee(106, "Frank", 75000, "Delhi", "India", "Tech"),
                new Employee(107, "Grace", 68000, "Bangalore", "India", "HR"),
                new Employee(108, "Hank", 92000, "London", "UK", "Tech"),
                new Employee(109, "Ivy", 61000, "New York", "USA", "Sales"),
                new Employee(110, "Jack", 87000, "Chicago", "USA", "Finance"),
                new Employee(111, "Kathy", 76000, "Paris", "France", "HR"),
                new Employee(112, "Leo", 99000, "Berlin", "Germany", "Tech"),
                new Employee(113, "Mona", 71000, "Paris", "France", "Finance"),
                new Employee(114, "Nina", 67000, "Delhi", "India", "Sales"),
                new Employee(115, "Oscar", 93000, "Bangalore", "India", "Tech"),
                new Employee(116, "Pam", 55000, "Mumbai", "India", "HR"),
                new Employee(117, "Quinn", 80000, "Berlin", "Germany", "Tech"),
                new Employee(118, "Raj", 72000, "Pune", "India", "Finance"),
                new Employee(119, "Sara", 88000, "London", "UK", "Sales"),
                new Employee(120, "Tom", 90000, "Chicago", "USA", "Tech")
        );
    }
}
