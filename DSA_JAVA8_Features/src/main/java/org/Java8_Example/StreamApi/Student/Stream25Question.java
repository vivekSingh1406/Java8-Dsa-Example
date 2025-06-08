package org.Java8_Example.StreamApi.Student;

import java.util.*;
import java.util.stream.Collectors;

public class Stream25Question {

    public static void main(String[] args) {

        List<Student> students = Student.getObject();

        /*------------------- Group students by college name -------------------*/
//        Map<String,List<Student>> studentByCollege = students.stream().collect(Collectors.groupingBy(Student::getCollegeName));
//        for (Map.Entry<String, List<Student>> entry : studentByCollege.entrySet()) {
//            System.out.println(entry.getKey() + "--> "+ entry.getValue());
//        }

        /*------------------- Average fees per department -----------------------*/
//        Map<String, Double> avgFeesByDept = students.stream().collect(Collectors.groupingBy(Student::getDepartment,
//                Collectors.averagingDouble(Student::getFees)));
//        for (Map.Entry<String, Double> entry : avgFeesByDept.entrySet()) {
//            System.out.println(entry.getKey() + "--> "+ entry.getValue());
//        }

        /*------------------ Find the student with the highest fees -----------------*/
//        Optional<Student> highestFee = students.stream()
//                .max(Comparator.comparingDouble(Student::getFees));
//        System.out.println(highestFee);

        /*------------------Get max fees per college ---------------------*/
//        Map<String, Optional<Student>> eachCollegeMaxFee = students.stream()
//                .collect(Collectors.groupingBy(
//                        Student::getCollegeName,
//                        Collectors.maxBy(Comparator.comparingDouble(Student::getFees))
//                ));
//        for (Map.Entry<String, Optional<Student>> entry : eachCollegeMaxFee.entrySet()) {
//            System.out.println(entry.getKey() + "--> "+ entry.getValue());
//        }

        /*----------------- Sort students by fees descending, then by name ascending --------------*/
//        students.stream()
//                .sorted(Comparator.comparingDouble(Student::getFees).reversed()
//                .thenComparing(Student::getName)).forEach(System.out::println);

        /*--------------- Get list of unique cities students belong to ----------------------*/
//        students.stream().map(Student::getCity).distinct().forEach(System.out::println);

        /*---------------  Find total fees collected by each college -----------------------*/
//        Map<String, Double> totalFeesByCollege = students.stream()
//                .collect(Collectors.groupingBy(Student::getCollegeName, Collectors.summingDouble(Student::getFees)));
//
//        for (Map.Entry<String, Double> entry : totalFeesByCollege.entrySet()) {
//            System.out.println(entry.getKey() + "--> "+ entry.getValue());
//        }

        /*-------------------- Partition students into high-payers (fees > 50000) and others --------------*/
//        Map<Boolean, List<Student>> partitioned = students.stream()
//                .collect(Collectors.partitioningBy(s-> s.getFees()> 50000));
//
//        for(Map.Entry<Boolean, List<Student>> entry : partitioned.entrySet()){
//            System.out.println(entry.getKey() + "--> "+ entry.getValue());
//        }

        /*---------------  Check if any student is from "Delhi" -------------------*/
//        boolean anyFromDelhi  = students.stream().anyMatch(s-> s.getCity().equals("Delhi"));
//        System.out.println(anyFromDelhi);

        /*-------------- List of student names in uppercase from a specific department (e.g., "CSE") -----------*/

//        students.stream()
//                .filter(s -> "CSE".equalsIgnoreCase(s.getDepartment()))
//                .map(s -> s.getName().toUpperCase())
//                .forEach(System.out::println);

        /*------------ Group students by department, then by city. (Multi-level grouping) ------------------*/

//        Map<String, Map<String, List<Student>>> deptCityMap = students.stream()
//                .collect(Collectors.groupingBy(Student::getDepartment,
//                        Collectors.groupingBy(Student::getCity)));
//
//        for(Map.Entry<String, Map<String, List<Student>>> entry : deptCityMap.entrySet()){
//            System.out.println(entry.getKey() + "--> "+ entry.getValue());
//        }

        /*------------  Get a comma-separated list of all college names (distinct) -----------------*/

//        String collegesName = students.stream()
//                .map(Student::getCollegeName)
//                .distinct()
//                .collect(Collectors.joining(" "));
//
//        System.out.println(collegesName);


        /*------------- Students whose names start with "A" ---------------------*/
//        students.stream()
//                .filter(s-> s.getName().
//                        startsWith("A"))
//                .forEach(System.out::println);


        /*----------  Students from BITS in Hyderabad -------------------*/
//        students.stream()
//                .filter(s-> s.getCollegeName()
//                        .startsWith("BITS") &&
//                        s.getCity().equals("Hyderabad"))
//                .forEach(System.out::println);


        /*------------ List of student names who have fees < 60000 -----------------*/
//        students.stream()
//                .filter(s-> s.getFees() > 60000)
//                .map(Student::getName).forEach(System.out::println);


        /*----------- Students sorted by city, then name ----------------*/

//        students.stream()
//                .sorted(Comparator.comparing(Student::getCity)
//                        .thenComparing(Student::getName))
//                .forEach(System.out::println);


        /*------------- List of departments available ----------------*/
//        students.stream()
//                .map(Student::getDepartment)
//                .distinct()
//                .forEach(System.out::println);


        /*----------- Count of students in each city -----------------*/
        Map<String, Long> cityCount = students.stream().collect(Collectors.groupingBy(Student::getCity,
                Collectors.counting()));

//        for(Map.Entry<String, Long> entry : cityCount.entrySet()){
//            System.out.println(entry.getKey() +"--> "+ entry.getValue());
//        }


        /*---------- Second highest fee student ------------------*/
//        Student secondHighestFee = students.stream()
//                .sorted(Comparator.comparingDouble(Student::getFees).reversed())
//                .skip(1)
//                .findFirst()
//                .orElse(null);
//        System.out.println(secondHighestFee);


        /*------------- Second low fee student ------------------*/
//        Student secondLowFee = students.stream()
//                .sorted(Comparator.comparingDouble(Student::getFees))
//                .skip(1)
//                .findFirst()
//                .orElse(null);
//        System.out.println(secondLowFee);

        /*------------------------------------------------------------------------------------------*/
        /*------------------------------------------------------------------------------------------*/
        /*-----------------------------------------VIVEK SINGH BAIS --------------------------------*/
        /*------------------------------------------------------------------------------------------*/
        /*------------------------------------------------------------------------------------------*/


        /*--------- List all students grouped by fees range (e.g., <50k, 50k–70k, >70k) ---------------*/
//
//        Map<String, List<Student>> byFeeRange = students.stream()
//                .collect(Collectors.groupingBy(s-> {
//                    if(s.getFees() < 50000) return "Low";
//                    else if(s.getFees() <= 70000) return "Medium";
//                    else return "High";}));
//        for(Map.Entry<String,List<Student>> entry : byFeeRange.entrySet()){
//            System.out.println(entry.getKey() + "--> "+ entry.getValue());
//        }


        /*--------- Create a map of college → set of unique cities students come from ----------------*/

//        Map<String, Set<String>> citiesPerCollege = students.stream()
//                .collect(Collectors.groupingBy(
//                        Student::getCollegeName,
//                        Collectors.mapping(Student::getCity, Collectors.toSet())
//                ));

//        for(Map.Entry<String, Set<String>> entry : citiesPerCollege.entrySet()){
//            System.out.println(entry.getKey() + "--> " + entry.getValue());
//        }


        /*-------- Find second student with lowest fees in “CSE” department ------------------*/

//        Optional<Student> secondLowestCSE = students.stream()
//                .filter(s-> s.getDepartment().equals("CSE"))
//                .sorted(Comparator.comparingDouble(Student::getFees))
//                .skip(1)
//                .findFirst();
//        System.out.println(secondLowestCSE.get());

        /*------------ Count distinct departments across all colleges ----------------*/

//        long allDistinctCollegeCount  = students.stream()
//                .map(Student::getDepartment)
//                .distinct()
//                .count();
//        System.out.println("count Distinct college count: "+ allDistinctCollegeCount);


        /*------------- Check if all students in “IIT” pay more than 70,000 --------------*/
//        boolean allIITStudentsHighFees = students.stream()
//                .filter(s -> s.getCollegeName().equals("IIT"))
//                .allMatch(s -> s.getFees() > 70000);
//        System.out.println("AllIITStudentsHighFees -> " + allIITStudentsHighFees);

        /*--------------  Get the list of departments in each city --------------------*/

//        Map<String, Set<String>> departmentsPerCity = students.stream()
//                .collect(Collectors.groupingBy(
//                        Student::getCity,
//                        Collectors.mapping(Student::getDepartment, Collectors.toSet())
//                ));
//        for(Map.Entry<String, Set<String>> entry : departmentsPerCity.entrySet()){
//            System.out.println(entry.getKey()+"--> "+ entry.getValue());
//        }

        /*------------- Get total fees collected in each city -----------------*/

//        Map<String, Double> totalFeesByCity = students.stream()
//                .collect(Collectors.groupingBy(Student::getCity, Collectors.summingDouble(Student::getFees)));
//
//        for(Map.Entry<String, Double> entry : totalFeesByCity.entrySet()){
//            System.out.println(entry.getKey()+ "--> "+ entry.getValue());
//        }


        /*----------- Get the student(s) with the longest name -------------------*/

//        Optional<Student> longestName = students.stream()
//                .max(Comparator.comparingInt(s-> s.getName().length()));
//        System.out.println(longestName.get());



        /*------------ Get list of student names per department -------------*/

        Map<String, List<String>> namesByDept = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getDepartment,
                        Collectors.mapping(Student::getName, Collectors.toList())
                ));
//        for(Map.Entry<String, List<String>> entry : namesByDept.entrySet()){
//            System.out.println(entry.getKey()+ "--> "+ entry.getValue());
//        }

        /*-------------  Get total number of students per college -----------*/

        Map<String, Long> countByCollege = students.stream()
                .collect(Collectors.groupingBy(Student::getCollegeName, Collectors.counting()));

//        for(Map.Entry<String, Long> entry : countByCollege.entrySet()){
//            System.out.println(entry.getKey()+ "--> "+ entry.getValue());
//        }


        /*-------- Find student(s) paying minimum fees in each department ------------*/

        Map<String, Optional<Student>> minFeePerDept = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getDepartment,
                        Collectors.minBy(Comparator.comparingDouble(Student::getFees))
                ));
        for(Map.Entry<String, Optional<Student>> entry : minFeePerDept.entrySet()){
            System.out.println(entry.getKey()+ "--> "+ entry.getValue().get());
        }

    }
}
