package org.Java8_Example.StreamApi.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Stream20Question {

    public static void main(String[] args) {

        List<Employee> employees = Employee.getObject();


//  -------------------  filter employees by a specific city  -----------------
        List<Employee> empFilterByCity = employees.stream()
                .filter(t-> "New York".equals(t.getCity())).toList();
        empFilterByCity.forEach(System.out::println);

//  -------------------  names of all employees as a List<String> --------------
        List<String> getEmpAllEmpName = employees.stream()
                .map(Employee::getName).toList();
        getEmpAllEmpName.forEach(System.out::println);


//  -------------------- calculate the average salary of employees -------------
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary).average().orElse(0);
        System.out.println("Employee average salary "+ averageSalary);


//  -------------------  find the employee with the highest salary -------------
        Optional<Employee> highestEmp = employees.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println("Highest Salary Employee details "+highestEmp.get());


//  ------------------- group employees by departmentName  -------------------
        Map<String, List<Employee>> groupByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentName));
        System.out.println(groupByDepartment);


//  ------------------  get a list of unique cities name  --------------------

        List<String> getUniqueCitiesName = employees.stream()
                .map(Employee::getCity).distinct().toList();
        System.out.println(getUniqueCitiesName);

//  ------------------ sort employees by salary in descending order --------------

        List<Employee> sortEmpByDesc = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .toList();
        System.out.println(sortEmpByDesc);

//  ----------------- find the total salary expense of all employees  --------------

        double sumTotalSalary = employees.stream()
                .mapToDouble(Employee::getSalary).sum();
        System.out.println(sumTotalSalary);


//  ----------------- map from employee id to employee name ------------------
        Map<Integer, String> mapIdName = employees.stream()
                .collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println(mapIdName);


//  -----------------  map of department names to list of employee names ----------------

        Map<String, List<String>> deptToEmployeeNames = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentName,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(deptToEmployeeNames);

//  ----------------- sum up salaries grouped by department -------------------

        Map<String, Double> totalSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentName,
                        Collectors.summingDouble(Employee::getSalary)));
        System.out.println(totalSalaryByDept);

//  ---------------------  count the number of employees in each country----------------

        Map<String, Long> countByCountry = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCountry, Collectors.counting()));
        System.out.println(countByCountry);

//  -----------------  comma-separated string of all department names ----------------

        String departments = employees.stream()
                .map(Employee::getDepartmentName).distinct()
                .collect(Collectors.joining(", "));
        System.out.println(departments);

//  ---------------  employee with the lowest salary -------------------------

        Optional<Employee> lowestSalary = employees.stream()
                .min((Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(lowestSalary);


//  ----------------------   salary of all employees by 10% using streams -------------------------

        List<Employee> increasedSalaries = employees.stream()
                .map(e-> new Employee(e.getId(), e.getName(), e.getSalary()*1.1, e.getCity(), e.getCountry(), e.getDepartmentName()))
                .toList();
        System.out.println(increasedSalaries);

//  ------------------------  find the second highest salaried employee ----------------------------
        Optional<Employee> secondHighest = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .skip(1).findFirst();


    }
}
