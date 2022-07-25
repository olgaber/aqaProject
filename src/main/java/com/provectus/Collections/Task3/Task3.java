/*
Написать программу, которая удаляет из коллекции все дубликаты, если они есть.
Вывести обе коллекции на экран и количество удалённых дубликатов.
Задачу можно решить несколькими способами, для каждого из способов нужно замерить время,
в конце - сравнить какой метод быстрее.
*/

package com.provectus.Collections.Task3;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {

        List<String> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add("Ukrainian");
        listWithDuplicates.add("English");
        listWithDuplicates.add("Hebrew");
        listWithDuplicates.add("French");
        listWithDuplicates.add("Spanish");
        listWithDuplicates.add("Polish");
        listWithDuplicates.add("Hebrew");
        listWithDuplicates.add("Italian");
        listWithDuplicates.add("Hebrew");
        listWithDuplicates.add("Polish");
        listWithDuplicates.add("English");
        listWithDuplicates.add("Hebrew");
        listWithDuplicates.add("Portuguese");
        listWithDuplicates.add("Polish");

        System.out.println("Initial list with duplicates: " + listWithDuplicates.toString() + "\n");

       // The first way
        long m1 = System.currentTimeMillis();
        Set<String> set = new HashSet<>();

        set.addAll(listWithDuplicates);

        System.out.println("First way: " + set.toString());
        System.out.println("Time (way one): " + (double) (System.currentTimeMillis() - m1) + "\n");

        //The second way
        long m2 = System.currentTimeMillis();
        List<String> listWithoutDuplicates = new ArrayList<>();
        List<String> duplicates = new ArrayList<>();

        for (String value: listWithDuplicates){
            if(!listWithoutDuplicates.contains(value)){
                listWithoutDuplicates.add(value);
            }
            else{
                duplicates.add(value);
            }
        }

        Map<String, Long> frequency = duplicates.stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Second way: " + listWithoutDuplicates.toString());
        System.out.println("Duplicates quantity: ");
        frequency.forEach((k, v) -> System.out.println( k + ": " + v));
        System.out.println("Time (way two): " + (double) (System.currentTimeMillis() - m2) + "\n");

        //The third way
        long m3 = System.currentTimeMillis();
        List<String> listNoDups = listWithDuplicates.stream().distinct().collect(Collectors.toList());

        System.out.println("Third way: " + listNoDups.toString());
        System.out.println("Time (way three): " + (double) (System.currentTimeMillis() - m3));

        Faker faker = new Faker();
        System.out.println(faker.name().firstName() + " " + faker.name().lastName());

    }
}
