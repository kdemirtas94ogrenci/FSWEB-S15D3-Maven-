package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Kübra", "Demirtaş"));
        employees.add(new Employee(3, "Burak", "Civelek"));
        employees.add(new Employee(4, "Burak", "Civelek"));
        employees.add(new Employee(5, "Burak", "Civelek"));
        employees.add(new Employee(7, "Deniz", "Acay"));

    }
    public static List<Employee> findDuplicates(List<Employee> employees) {
        List<Employee> duplicates = new LinkedList<>();
        List<Employee> uniques = new LinkedList<>();

        for (Employee emp : employees) {
            if (emp == null)
                continue;

            if (uniques.contains(emp)) {
                duplicates.add(emp);
            } else {
                uniques.add(emp);
            }
        }


        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniques = new HashMap<>();

        for (Employee emp : employees) {
            if (emp != null && !uniques.containsKey(emp.getId())) {
                uniques.put(emp.getId(), emp);
            }
        }

        return uniques;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Employee, Integer> counts = new HashMap<>();

        for (Employee emp : employees) {
            if (emp == null) continue;
            counts.put(emp, counts.getOrDefault(emp, 0) + 1);
        }

        List<Employee> uniques = new LinkedList<>();
        for (Map.Entry<Employee, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                uniques.add(entry.getKey());
            }
        }

        return uniques;
    }
}
