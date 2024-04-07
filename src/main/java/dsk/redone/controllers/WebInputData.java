package dsk.redone.controllers;

import dsk.redone.repository.DataRepo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;


public class WebInputData implements InputDataController {

    /**
     * Ввод даты для определения курсов валют
     * @return String date
     */

    public String inputDate() {
        return  JOptionPane.showInputDialog(
                null,"Введите дату для определения курсов валют \n" +
                        "в формате dd/мм/гггг");
    }

    /**
     * Выбор названия валюты из списка актуальных валют на сайте cbr
     *
     * @return String - название валюты
     */
    public String chooseCurrency(Object[] curNames) {
        return (String) JOptionPane.showInputDialog(null, "Please choose the currency type", "Выбор валюты",
                QUESTION_MESSAGE, null, curNames, 1);
    }

    /**
     * Выбор типа вывода данных
     * @return
     */
    @Override
    public String chooseOutputType() {
        return null;
    }
}
