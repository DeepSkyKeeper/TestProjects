package dsk.redone.controllers;

import dsk.redone.repository.DataRepo;
import dsk.redone.services.PrepareData;
import dsk.redone.services.PrepareRequests;
import dsk.redone.services.UrlConnector;
import dsk.redone.services.XmlParser;
import dsk.redone.view.ConsoleView;
import dsk.redone.view.UserView;
import dsk.redone.view.WebView;

import java.util.ArrayList;

public class AppController {
      public static String curName=null;
    public static void run() {
        String curId;
        Object[] curNames = null;
        ArrayList<String> urlList = new ArrayList<>();
        //запускаем контроллер ввода
        InputDataController inputController = new WebInputData();
//        InputDataController inputController = new ConsoleInputData();
        //Создаем репозиторий
        DataRepo repo = XmlParser.createXmlParser();
        //читаем список актуальных валют
        //проверка ответа
        //если ответа нет вывод сообщения об ошибке
        ;
        if (repo.getCurList() == null) {
            System.out.println("Не удается получить список валют");
            System.exit(1);
        } else
            //пишем валюты в репозиторий
            //выбираем валюту
            curNames = repo.getCurNames().toArray();
        curName=inputController.chooseCurrency(curNames);
        curId = repo.getIdByCurName(curName);
        //поиск id по названию валюты в репозитории

        //выбираем источник для вывода
//        inputController.chooseOutputType();
        //ввод даты
        //парсим строку - конвертим в дату
        //создаем доп даты
        PrepareData data = new PrepareData(inputController.inputDate());
        //готовим запросы
        PrepareRequests requests = new PrepareRequests(data.getDateList(), curId);
        urlList = requests.getUrlList();
        //читаем курсы по датам
        urlList.forEach(repo::setErList);
        //создаем список моделей
        //наполняем модели
        //выводим данные
//        UserView view = new ConsoleView();
        UserView view = new WebView();
        view.dataOut();
    }
}
