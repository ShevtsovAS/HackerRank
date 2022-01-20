package com.hackerrank.basic.data_structures.priority_queue;

import lombok.Value;

import java.util.*;

@Value
class Student {
    int id;
    String name;
    double cgpa;
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        Comparator<Student> studentComparator = Comparator
                .comparingDouble(Student::getCgpa).reversed()
                .thenComparing(Student::getName)
                .thenComparing(Student::getId);
        Queue<Student> queue = new PriorityQueue<>(studentComparator);
        events.forEach(event -> {
            String[] instructions = event.trim().split("\\s+");
            String operation = instructions[0];
            if ("ENTER".equals(operation)) {
                String name = instructions[1];
                double cgpa = Double.parseDouble(instructions[2]);
                int id = Integer.parseInt(instructions[3]);
                queue.add(new Student(id, name, cgpa));
            } else if ("SERVED".equals(operation)) {
                queue.poll();
            }
        });

        List<Student> students = new ArrayList<>();
        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }

        return students;
    }
}

//https://www.hackerrank.com/challenges/java-priority-queue/problem
public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
