package dsk.redone.controllers;

import javax.swing.*;
import java.util.Scanner;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;


public class WebInputData implements InputDataController{
   public static void run(){
       //выбираем валюту
       //вводим дату
   }

    public String inputDate() {
        System.out.println("Введите дату для определения курсов валют");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public String chooseCurrency(){
//        message – the Object to display title – the String to display in the dialog title bar
//        messageType – the type of message to be displayed: ERROR_MESSAGE, INFORMATION_MESSAGE,
//        WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE
//        icon – the Icon image to display
//        selectionValues – an array of Objects that gives the possible selections
//        initialSelectionValue – the value used to initialize the input field

        JOptionPane.showInputDialog(null,"Please choose the currency type",
                QUESTION_MESSAGE,null,);
                return null;
    }
}
