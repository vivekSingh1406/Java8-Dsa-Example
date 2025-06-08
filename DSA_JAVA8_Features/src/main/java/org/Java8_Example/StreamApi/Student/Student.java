package org.Java8_Example.StreamApi.Student;


import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private String collegeName;
    private String department;
    private double fees;
    private String city;

    // Constructor
    public Student(String name, String collegeName, String department, double fees, String city) {
        this.name = name;
        this.collegeName = collegeName;
        this.department = department;
        this.fees = fees;
        this.city = city;
    }

    public String getName() { return name; }
    public String getCollegeName() { return collegeName; }
    public String getDepartment() { return department; }
    public double getFees() { return fees; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return name + " - " + collegeName + " - " + department + " - " + fees + " - " + city;
    }


    public static List<Student> getObject() {
        return Arrays.asList(
                new Student("Aman", "IIT", "CSE", 80000, "Delhi"),
                new Student("Rita", "NIT", "ECE", 65000, "Mumbai"),
                new Student("Varun", "IIT", "ME", 70000, "Delhi"),
                new Student("Neha", "BITS", "CSE", 75000, "Hyderabad"),
                new Student("Raj", "NIT", "CSE", 60000, "Chennai"),
                new Student("Simran", "BITS", "EEE", 72000, "Pune"),
                new Student("Deepak", "IIT", "CSE", 85000, "Delhi"),
                new Student("Priya", "VIT", "IT", 50000, "Mumbai"),
                new Student("Karan", "VIT", "CSE", 52000, "Mumbai"),
                new Student("Anjali", "IIT", "CSE", 81000, "Delhi"),
                new Student("Nisha", "BITS", "ME", 68000, "Pune"),
                new Student("Aakash", "NIT", "EEE", 62000, "Mumbai"),
                new Student("Meena", "IIT", "CSE", 77000, "Bangalore"),
                new Student("Rohan", "VIT", "CSE", 49000, "Chennai"),
                new Student("Sana", "BITS", "ECE", 70000, "Hyderabad"),
                new Student("Arjun", "NIT", "ME", 58000, "Delhi"),
                new Student("Tina", "IIT", "IT", 74000, "Bangalore"),
                new Student("Ishaan", "BITS", "CSE", 78000, "Hyderabad"),
                new Student("Divya", "VIT", "CSE", 53000, "Pune"),
                new Student("Gaurav", "NIT", "CSE", 59000, "Chennai")
        );
    }
}
