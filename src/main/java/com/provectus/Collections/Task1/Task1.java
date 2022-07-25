/*
        Игра Jолушка 1.0: распихиваиние чисел по трем спискам. Правила таковы: Jолушка получила список из 20 чисел.
        Ей нужно проверить, какие из них нацело делятся на 3, какие на 2, а какие — ни на то, ни на другое.
        Затем ей нужно сохранить их в отдельные списки. Числа, которые делятся на 3 и на 2 одновременно,
        например 6, попадают в оба списка. Решаем!
 */

package com.provectus.Collections.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {

        // Create a 20 elements list
        Random random = new Random();
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            arrayList.add(random.nextInt(100));
        }

        System.out.println(arrayList.toString());

        // Distribute to different lists
        List<Integer> devidedByTwo = new ArrayList<>();
        List<Integer> devidedByThree = new ArrayList<>();
        List<Integer> notDevided = new ArrayList<>();

        for (int number: arrayList){
            if (number % 2 == 0){
                devidedByTwo.add(number);
            }
            if (number % 3 == 0){
                devidedByThree.add(number);
            }
            if (number % 2 !=0 && number % 3 != 0){
                notDevided.add(number);
            }
        }

        System.out.println("Devided by two: " + devidedByTwo.toString());
        System.out.println("Devided by three: " + devidedByThree.toString());
        System.out.println("Not devided nither by two nor three: " + notDevided.toString());
    }
}
