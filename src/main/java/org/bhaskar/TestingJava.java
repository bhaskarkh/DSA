package org.bhaskar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestingJava {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(
                new Employee(1,"a",30,"it",3200.0),
                new Employee(2,"b",45,"hr",5200.0),
                new Employee(3,"c",25,"qa",2200.0),
                new Employee(4,"d",66,"dev",1200.0),
                new Employee(5,"e",28,"qa",9200.0),
                new Employee(6,"e",28,"qa",9200.0),
                new Employee(7,"e",28,"qa",9200.0),
                new Employee(8,"e",28,"qa",9200.0),
                new Employee(9,"f",30,"dev",7200.0)
                );

        for (Employee employee:employeeList){
            employeeList.remove(new Employee(1,"a",30,"it",3200.0));
            employeeList.add(new Employee(1,"a",30,"it",3200.0));
        }

        //Employee e1= new Employee("e",28,"qa",9200.0);
       // Employee e2= new Employee("e",28,"qa",9200.0);
       // Map<Employee, String> empMap = employeeList.stream().collect(Collectors.toMap(e -> e,Employee::getName));
       // empMap.forEach((k,v)-> System.out.println(k+"--->"+v.toString()));

        Map<Employee,Integer> map=new HashMap<>();
        map.put(new Employee(1,"a",30,"it",3200.0),1);
        map.put(new Employee(2,"a",30,"it",3200.0),2);
        map.put(new Employee(3,"a",30,"it",3200.0),3);
        map.put(new Employee(4,"a",30,"it",3200.0),4);
        System.out.println(map);
        map.put(new Employee(1,"a",30,"it",3200.0),4);
        System.out.println(map);

    }

    static class Employee {
        int empId;
        String name;
        int age;
        String dept;
        double salary;

        public Employee(int empId,String name, int age, String dept, double salary) {
            this.empId = empId;
            this.name = name;
            this.age = age;
            this.dept = dept;
            this.salary = salary;
        }

        public int getEmpId() {
            return empId;
        }

        public void setEmpId(int empId) {
            this.empId = empId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "empId='"+ empId + '\''+
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", dept='" + dept + '\'' +
                    ", salary=" + salary +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            Employee employee = (Employee) o;
            return employee.getEmpId()==empId;
        }

        @Override
        public int hashCode() {
            return empId;
        }
    }
}
