package dsk.redone.services;

import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class PrepareData {
    public PrepareData(String lData) {
        parseData(lData);
        addDate();
    }


    private LocalDate targetDate;
    @Getter
    public ArrayList<String> dateList;

    private void addDate() {
        dateList = new ArrayList<>();
        dateList.add(buildDate(targetDate));

        dateList.add(buildDate(targetDate.minusDays(1)));

        dateList.add(buildDate(targetDate.plusDays(1)));
    }

    /**
     * parseData - converting String data to the LocalDate
     *
     * @param lDate - data in format dd/MM/yyyy splited by "/"
     */
    private void parseData(String lDate) {
        int day;
        int month;
        int year;

        try {
            int p1 = lDate.indexOf("/");
            day = Integer.parseInt(lDate.substring(0, p1));
            int p2 = lDate.indexOf("/", p1 + 1);
            month = Integer.parseInt(lDate.substring(p1 + 1, p2));
            year = Integer.parseInt(lDate.substring(p2 + 1));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Some of input data is not a digit");
        }
        targetDate = LocalDate.of(year, month, day);
    }

    public String buildDate(LocalDate lDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(lDate);
    }
}
