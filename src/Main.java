package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Store store = new Store();

        while (true){
            int totalCost = 0;
            System.out.println("\nДоступные для заказа запчасти:");
            for (int i = 0; i < store.parts.size(); i++){
                Part part = store.parts.get(i);
                System.out.println((i + 1) + " " + part.name + " - " + part.price + " рублей. Количество: " + part.quantity);
            }

            int[] order = new int[10];
            System.out.println("\n\tВведите номер запчасти и его количество");

            int i = 0;
            while (i < store.parts.size()){
                System.out.print("\t" + (i+1) + " " + store.parts.get(i).name + ": ");
                order[i] = sc.nextInt();
                sc.nextLine();

                if (order[i] > store.parts.get(i).quantity){
                    System.out.println("\tНельзя выбрать больше, чем есть в наличии");
                }
                else{
                    System.out.println("\t" + (i+1) + " | " + store.parts.get(i).name + " | " + store.parts.get(i).weight + " кг | " + store.parts.get(i).price + " рублей.");
                    totalCost += order[i] * store.parts.get(i).price;
                    store.parts.get(i).quantity -= order[i];
                    i++;
                }

            }

            System.out.println("\n\t Итоговая стоимость: " + totalCost);

            System.out.print("\n\t Купить ещё (Да/Нет)?: ");
            String again = sc.nextLine();

            if (again.equals("Нет")){
                System.out.print("\n\tВсего доброго!");
                break;
            }

        }
    }
}
