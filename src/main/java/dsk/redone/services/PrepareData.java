package dsk.redone.services;

import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class PrepareData {
    public PrepareData(String lData) {
        parseData(lData);
        setCurDate();
        setPostDate();
        setPreDate();
    }


    private LocalDate targetDate;
    @Getter
    public String curDate;
    @Getter
    public String preDate;
    @Getter
    public String postDate;

    private void setCurDate() {
        curDate = buildDate(targetDate);
    }

    private void setPreDate() {
        preDate = buildDate(targetDate.minusDays(1));
    }

    private void setPostDate() {
        postDate = buildDate(targetDate.plusDays(1));
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
