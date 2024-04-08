package dsk.redone.services;

import dsk.redone.models.Currency;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @date String - расчетная дата, выбранная пользователем
 * @preDate - предыдущая дата
 * @postDate - следующая дата
 * @curId - id валюты
 */
@AllArgsConstructor
public class PrepareRequests {
    private final String date;
    private final String preDate;
    private final String postDate;
    private final String curId;


    /**
     * Готовит список ссылок для получения курсов валют за текущую, предыдущую и следующую дату
     *
     * @return ArrayList <String> urls
     */
    public ArrayList<String> getUrlList() {
        ArrayList<String> urls = new ArrayList<>();
        urls.add(buildUrl(curId, preDate));
        urls.add(buildUrl(curId, date));
        urls.add(buildUrl(curId, postDate));
        return urls;
    }

    /**
     * buildURL - создает url запрос для получения курсов с date1 по date2
     *
     * @param date1 String - first date of the period
     * @param date2 String - last date of the period
     * @param curId String - currency code
     * @return Ulr for cbr request
     */
    private static String buildUrl(String curId, String date1, String date2) {
        return "https://cbr.ru/scripts/XML_dynamic.asp?date_req1=" + date1
                + "&date_req2=" + date2 + "&VAL_NM_RQ=" + curId;
    }

    /**
     * buildURL - cbr currency request url builder for date
     *
     * @param date  String - target date
     * @param curId String - currency code
     * @return Ulr for cbr request
     */
    private static String buildUrl(String curId, String date) {
        return "https://cbr.ru/scripts/XML_dynamic.asp?date_req1=" + date
                + "&date_req2=" + date + "&VAL_NM_RQ=" + curId;
    }

}
