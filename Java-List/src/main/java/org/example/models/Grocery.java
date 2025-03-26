package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public void startGrocery(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("0: Uygulamayı Durdur");
            System.out.println("1: Eleman Ekle");
            System.out.println("2: Eleman Çıkar");
            System.out.print("Bir seçenek giriniz ");
            int prompt = scanner.nextInt();
            scanner.nextLine();

            if (prompt == 0) {
                System.out.println("Uygulama durduruluyor...");
                break;
            } else if (prompt == 1) {
                System.out.print("Eklemek istediğiniz eleman veya elemanları girin: ");
                String input = scanner.nextLine();
                addItems(input);
            } else if (prompt == 2) {
                System.out.print("Çıkarmak istediğiniz eleman veya elemanları girin: ");
                String input = scanner.nextLine();
                removeItems(input);
            } else {
                System.out.println("Lutfen gecerli bir islem giriniz!");
            }
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
