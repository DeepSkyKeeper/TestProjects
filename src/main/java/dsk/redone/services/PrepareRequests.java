package dsk.redone.services;

import dsk.redone.models.Currency;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PrepareRequests {
    private final String date;
    private final String preDate;
    private final String postDate;
    private String curId;
    private static final String CurrencyLibUrl = "https://cbr.ru/scripts/XML_val.asp?d=0";

    public ArrayList<String> getUrlList() {
        ArrayList<String> urls = new ArrayList<>();
        urls.add(buildUrl(curId, preDate));
        urls.add(buildUrl(curId, date));
        urls.add(buildUrl(curId, postDate));
        return urls;
    }

    /**
     * buildURL - cbr currency request url builder for period from date1 to date2
     *
     * @param date1   - first date of the period
     * @param date2   - last date of the period
     * @param curId - currency code
     * @return Ulr for cbr request
     */
    private static String buildUrl(String curId, String date1, String date2) {
        return "https://cbr.ru/scripts/XML_dynamic.asp?date_req1=" + date1
                + "&date_req2=" + date2 + "&VAL_NM_RQ=" + curId;
    }

    /**
     * buildURL - cbr currency request url builder for date
     *
     * @param date   - target date
     * @param curId - currency code
     * @return Ulr for cbr request
     */
    private static String buildUrl(String curId, String date) {
        return "https://cbr.ru/scripts/XML_dynamic.asp?date_req1=" + date
                + "&date_req2=" + date + "&VAL_NM_RQ=" + curId;
    }
    private List<Currency> getCurrencyCodes(){
        ArrayList<Currency> curList = new ArrayList<>();

        return curList;
    }
}
