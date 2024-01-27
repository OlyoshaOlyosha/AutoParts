package org.example;
import java.util.ArrayList;
import java.util.Random;


public class Store {
    ArrayList<Part> parts = new ArrayList<>();

    public Store() {
        String[] partNames = {"Тормозной диск", "Свеча зажигания", "Фильтр масляный", "Ремень ГРМ", "Амортизатор", "Радиатор", "Стартер", "Генератор", "Топливный насос", "Аккумулятор"};
        Random rand = new Random();

        for (int i = 0; i < partNames.length; i++) {
            int randomPrice = 500 + rand.nextInt(1500);
            int randomWeight = 1 + rand.nextInt(10);
            parts.add(new Part(partNames[i], 10, randomPrice, randomWeight));
        }
    }
}
