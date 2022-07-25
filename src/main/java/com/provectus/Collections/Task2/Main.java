/*
Создать программу - список покупок. В этот список заносятся объекты типа Product, у которого есть поля name, quantity,
price. Написать программу, которая выводит полный список покупок на экран (название - количество - общая стоимость).
Вывести список 2 раза: отсортированный по названию продуктов, и по общей стоимости.
*/

package com.provectus.Collections.Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Bread", 2, 6.74);
        Product p2 = new Product("Apples", 7, 5.36);
        Product p3 = new Product("Mint Tea", 1, 3.72);
        Product p4 = new Product("Butter", 3, 17.44);

        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);

        // Sort by name
        Collections.sort(productList, new ComparatorByName());
        System.out.println(productList.toString());

        // Sorted by price
        Collections.sort(productList, new ComparatorByPrice());
        System.out.println(productList.toString());
    }
}
