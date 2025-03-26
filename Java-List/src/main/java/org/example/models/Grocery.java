package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public void startGrocery(){
        Scanner scanner = new Scanner(System.in);

            System.out.println("Neler yapmak istersiniz? " +
                    "0 -> Listeyi kapatmak icin" +
                    "1 -> Listeye ekleme yapmak icin" +
                    "2 -> Listeden cikartma yapmak icin");
            int prompt = scanner.nextInt();

            if (prompt == 0) {
                return;
            } else if (prompt == 1) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz");
                scanner.nextLine();
            } else if (prompt == 2) {
                System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
            }
    }

    public static void addItems(String input){
        String [] items = input.split(",");
        for(String item : items){
            item = item.trim().toLowerCase();
            if(!groceryList.contains(item)){
                groceryList.add(item);
            } else {
                System.out.println("Malzeme listede mevcut! -> " + item);
            }
        } printSorted();
    }
    public static void removeItems(String input){
        String[] items = input.split(",");
        for(String item : items){
            if(groceryList.contains(item)){
                groceryList.remove(item);
                System.out.println(item +  " Listeden cikarildi");
            }else {
                System.out.println("Malzeme listede mevcut degil, ekleyebilirsiniz -> " +item);
            }
        } printSorted();
    }

    public static void checkItemIsInList(String product){ // silinen ya da eklenmeye calisan urun var mi yok mu??
       product = product.toLowerCase().trim();
        if(groceryList.contains(product)){
            System.out.println("Malzeme listede mevcut!");
        }else {
            System.out.println("Malzeme listede yok!");
        }
    }
    public static void printSorted(){
        Collections.sort(groceryList);
        System.out.println("Güncellenmiş ve sıralanmış liste: " + groceryList);
    }

}
