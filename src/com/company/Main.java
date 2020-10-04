package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main extends FileOperation {

    public static void main(String[] args) throws IOException {
        Country[] countries = new Country[1];

        String filename = "note.txt", reservFilename = "reservNote.txt";
        String choise = "";

        System.out.print("Добро пожаловать! Выберите действие:\n" +
                           "  1. Добавить страну" +
                           "  2. Убрать страну" +
                           "  3. Сохранить базу данных" +
                           "  4. Загрузить начальную копию базы данных\n" +
                           "Ваш выбор: ");

        countries = Load(filename);
        Save(reservFilename, countries);

        Scanner scanner = new Scanner(System.in);

        while (!choise.equals("5"))
        {
            choise = Country.CheckNumberOrTitle(scanner.nextLine(), "number");

            switch (choise)
            {
                case "1": countries = Country.Add(countries); break;
                case "2": countries = Country.Delete(countries); break;
                case "3": Save(filename, countries); break;
                case "4": countries = Load(reservFilename); break;
                case "5": System.out.println("Завершение программы"); break;
                default: System.out.println("Не верное значение. Попробуйте еще раз");
            }
        }
    }
}
