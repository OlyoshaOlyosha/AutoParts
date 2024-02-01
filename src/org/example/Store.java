package org.example;

import java.io.*;
import java.util.*;

public class Store {
    ArrayList<Part> parts = new ArrayList<>();
    String fileName = "parts.txt";

    public Store() {
        File file = new File(fileName);
        // Если нет файла - генерируем, иначе достаём информацию о количестве товаров
        if (file.exists()) {
            loadPartsFromFile();
        } else {
            generateParts();
            savePartsToFile();
        }
    }

    private void loadPartsFromFile() {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] partsData = line.split(" \\| ");
                String id = partsData[0];
                String name = partsData[1];
                int weight = Integer.parseInt(partsData[2].split(" ")[0]);
                int price = Integer.parseInt(partsData[3].split(" ")[0]);
                int quantity = Integer.parseInt(partsData[4]);
                parts.add(new Part(id, name, quantity, price, weight));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void generateParts() {
        String[] partNames = {"Тормозной диск", "Свеча зажигания", "Фильтр масляный", "Ремень ГРМ", "Амортизатор", "Радиатор", "Стартер", "Генератор", "Топливный насос", "Аккумулятор"};
        Random rand = new Random();
        for (int i = 0; i < partNames.length; i++) {
            String id = String.format("%04d", i + 1);
            int randomPrice = rand.nextInt(500, 1500);
            int randomWeight = rand.nextInt(1, 10);
            parts.add(new Part(id, partNames[i], 10, randomPrice, randomWeight));
        }
    }

    public void savePartsToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (Part part : parts) {
                writer.write(part.id + " | " + part.name + " | " + part.weight + " кг. | " + part.price + " рублей | " + part.quantity);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}