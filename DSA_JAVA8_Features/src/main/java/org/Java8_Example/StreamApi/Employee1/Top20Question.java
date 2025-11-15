package org.Java8_Example.StreamApi.Employee1;

import org.Java8_Example.StreamApi.Employee.Employee;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Top20Question {

    public static void main(String[] args) {

        List<Employee> employee = Employee.getObject();

        //  filter employees whose names start with a vowel
        List<Employee> startWithVowel = employee.stream()
                .filter(t -> !t.getName().isEmpty() &&
                        "aeiouAEIOU".indexOf(t.getName().charAt(0)) != -1)
                .toList();
//        startWithVowel.forEach(System.out::println);

        // count the employees who are in India and whose names start with a consonant
        List<Employee> indiaWithConsonant = employee.stream()
                .filter(t-> "India".equalsIgnoreCase(t.getCountry()))
                .filter(t-> "aeiouAEIOU".indexOf(t.getName().charAt(0))==-1)
                .toList();
//        indiaWithConsonant.forEach(System.out::println);

        // sort the list by salary asc
        List<Employee> sortByAsc = employee.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();
//        sortByAsc.forEach(System.out::println);

        // sort the list by salary desc
        List<Employee> sortByDesc = employee.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .toList();
//        sortByDesc.forEach(System.out::println);

        // fist sort by country then sort by salary
        List<Employee> sortByCountryThenSalary = employee.stream()
                .sorted(Comparator.comparing(Employee::getCountry)
                        .thenComparing(Employee::getSalary))
                .toList();
//        sortByCountryThenSalary.forEach(System.out::println);

        // group by country
        Map<String, List<Employee>> groupByCountry = employee.stream()
                    .collect(Collectors.groupingBy(Employee::getCountry));
//        groupByCountry.forEach((key, value) -> System.out.println(key + " ---- " + value));

        // group by country, find sun of each group
        Map<String, Double> groupByCountryAddSalary = employee.stream()
                 .collect(Collectors.groupingBy(
                        Employee::getCountry,
                        Collectors.summingDouble(Employee::getSalary)));
//        groupByCountryAddSalary.forEach((country, sal) -> System.out.println(country +"----"+ sal));


        // group by country, find avg of each group
        Map<String, Double> groupByCountryAvgSalary = employee.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCountry,
                        Collectors.averagingDouble(Employee::getSalary)));
//        groupByCountryAvgSalary.forEach((county, avg)-> System.out.println(county +"----"+ avg));


        // group by country, count each emp group
        Map<String,Long> countEachGroup = employee.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCountry,
                        Collectors.counting()));
//        countEachGroup.forEach((county, num)-> System.out.println(county +"----"+ num));


        // find only emp name in a list
        List<String> empName = employee.stream()
                .map(Employee::getName)
                .distinct()
                .toList();
//        empName.forEach(System.out::println);

        // find highest salary of Employee details
        Optional<Employee> highestSalaryEmployee = employee.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .findFirst();

//        highestSalaryEmployee.ifPresentOrElse(
//                System.out::println,
//                ()-> System.out.println("no highest salary")
//        );

        // find second-highest salary of Employee details
        Optional<Employee> secondHighestSalary = employee.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
//        secondHighestSalary.ifPresentOrElse(
//                System.out::println,
//                ()-> System.out.println("no second highest salary")
//        );

    }
}
