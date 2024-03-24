package dsk.redone.controllers;

public class AppController {
    public void run() {
        //создаем список валют

        InputDataController inputController = new WebInputData();
        //выбираем валюту
        inputController.chooseCurrency();
        //вводим дату
        inputController.inputDate();

        //выбираем источник для вывода

        //парсим строку - конвертим в дату
        //создаем доп даты
        //читаем курсы по датам
        //создаем список моделей
        //наполняем модели
        //выводим данные
    }
}
