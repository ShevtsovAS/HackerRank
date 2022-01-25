package com.hackerrank.advanced.annotations;

import lombok.SneakyThrows;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface FamilyBudget {
    String userRole() default "GUEST";

    int budget();
}

@SuppressWarnings("unused")
class FamilyMember {

    @FamilyBudget(userRole = "SENIOR", budget = 100)
    public void seniorMember(int budget, int moneySpend) {
        System.out.println("Senior Member");
        System.out.println("Spend: " + moneySpend);
        System.out.println("Budget Left: " + (budget - moneySpend));
    }

    @FamilyBudget(userRole = "JUNIOR", budget = 50)
    public void juniorUser(int budget, int moneySpend) {
        System.out.println("Junior Member");
        System.out.println("Spend: " + moneySpend);
        System.out.println("Budget Left: " + (budget - moneySpend));
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases-- > 0) {
            String role = in.next();
            int spend = in.nextInt();
            executeFamilyMemberMethods(role, spend);
        }
    }

    private static void executeFamilyMemberMethods(String role, int spend) {
        getBudgetMethods(FamilyMember.class, FamilyBudget.class).forEach(method -> {
            FamilyBudget family = method.getAnnotation(FamilyBudget.class);
            String userRole = family.userRole();
            int budgetLimit = family.budget();
            if (userRole.equals(role)) {
                invokeMethod(method, spend, budgetLimit);
            }
        });
    }

    @SuppressWarnings("SameParameterValue")
    private static List<Method> getBudgetMethods(Class<?> aClass, Class<? extends Annotation> annotation) {
        return Arrays.stream(aClass.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(annotation))
                .collect(toList());
    }

    @SneakyThrows
    private static void invokeMethod(Method method, int spend, int budgetLimit) {
        if (spend <= budgetLimit) {
            method.invoke(new FamilyMember(), budgetLimit, spend);
        } else {
            System.out.println("Budget Limit Over");
        }
    }

}
