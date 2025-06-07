package org.example.java8.stream_api;


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
}
