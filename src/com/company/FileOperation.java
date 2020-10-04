package com.company;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileOperation
{
    public static void Save(String filename, Country[] countries) throws IOException
    {
        FileWriter fw = new FileWriter(filename);

        try
        {
            fw.write(countries.length + "\n");

            for(int i = 0; i < countries.length; i++)
            {
                fw.write(countries[i].name + "\n");
                fw.write(countries[i].capital + "\n");
                fw.write(countries[i].population + "\n");
            }
        }
        catch (IOException ex)
        {
            System.out.println("Ошибка: " + ex.getMessage());
        }

        fw.close();
    }

    public static Country[] Load(String filename) throws IOException
    {
        Scanner scanner = new Scanner(new FileReader(filename));
        int i = 0;

        Country[] countries = new Country[Integer.parseInt(scanner.nextLine())];

        for(int j = 0; j < countries.length; j++)
            countries[j] = new Country();

        while (scanner.hasNextLine())
        {
            countries[i].name = scanner.nextLine();
            countries[i].capital = scanner.nextLine();
            countries[i].population = Integer.parseInt(scanner.nextLine());

            i++;
        }

        return countries;
    }

}
