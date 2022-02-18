package com.company;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Warehouse {
    public static int size = 1000;
    private HashMap<String, Integer>  products = new HashMap<>();


    public void chooseComm(){
        System.out.println("Какую команду хотите использовать? Add - Добавить товар, Delete - удалить товар, Check - проверить есть ли товар и его количество, Show - сколько всего товаров на складе, Exit - выход из программы");
        String chooseCommand = new Scanner(System.in).nextLine().toLowerCase().trim();
        switch (chooseCommand){
            case "add":
                this.add();
                break;
            case "delete":
                this.delete();
                break;
            case "check":
                this.check();
                break;
            case "show":
                this.show();
                break;
            case "exit":
                System.out.println("Конец программы");
                break;
            default:
                System.out.println("Вы ввели что-то не то. Давайте попробуем снова");
                this.chooseComm();
                break;
        }
    }

    public void add(){
        System.out.println("Введите название товара, который хотите добавить");
        String name = new Scanner(System.in).nextLine().toLowerCase().trim();
        System.out.println("Введите количество товара, который хотите добавить");
        int quantity = new Scanner(System.in).nextInt();
        if(quantity>0){
        int allQ = 0;
        for (Map.Entry<String, Integer> key: products.entrySet()){
            allQ+=key.getValue();
        }

        if(allQ+quantity>size){
            int stay = size-allQ;
            System.out.println("На складе не хватает места. Есть только "+stay+" свободных мест");
        } else {
            boolean a = products.containsKey(name);
            if (a) {
                int q = products.get(name);
                products.put(name, q + quantity);
            } else {
                products.put(name, quantity);
            }
            System.out.println("Товар " + name + " добавлен");
        }
        }  else {
            System.out.println("Нельзя добавить отрицательное количество товара");
        }
        this.chooseComm();
    }

    public void delete(){
        System.out.println("Введите название товара, который хотите удалить");
        String name = new Scanner(System.in).nextLine().toLowerCase().trim();

        boolean a = products.containsKey(name);
        if(a){
            int q = products.get(name);
            System.out.println("В наличии "+q+". Сколько удалить?");
            int quantity = new Scanner(System.in).nextInt();
            if(quantity>=0){
            if(quantity>=q){
                products.remove(name);
            }  else {
                products.put(name, q - quantity);
            }
            System.out.println("Удалено");
            } else {
                System.out.println("Нельзя убавить отрицательное число");
            }
        } else {
            System.out.println("Такого товара и не было");
        }
        this.chooseComm();
    }

    public void check(){
        System.out.println("Введите название товара, который проверить на наличие");
        String name = new Scanner(System.in).nextLine().toLowerCase().trim();

        boolean a = products.containsKey(name);
        if(a){
            int q = products.get(name);
            System.out.println(name + " есть на складе. В наличии: "+ q);
        } else {
            System.out.println("Нет в наличии товара "+name);
        }
        this.chooseComm();
    }

    public void show(){
        int allQ = 0;
        for (Map.Entry<String, Integer> key: products.entrySet()){
            allQ+=key.getValue();
        }
        System.out.println("Всего товара на складе: "+allQ+"шт");

        this.chooseComm();
    }
}