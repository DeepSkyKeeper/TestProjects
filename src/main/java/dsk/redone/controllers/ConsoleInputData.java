package dsk.redone.controllers;

import java.util.Scanner;

public class ConsoleInputData implements InputDataController{
    @Override
    public String inputDate() { System.out.println("Введите дату для определения курсов валют");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public String chooseCurrency(Object[] curNames) {
        int i=0;
        System.out.println("Выберите валюту:");
        for (Object curName : curNames) {
            System.out.println(i+" - "+curName);
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        return (String)curNames[0];
    }

    @Override
    public String chooseOutputType() {
        return "";
    }
}
