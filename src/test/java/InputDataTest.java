import dsk.redone.models.ExRate;
import dsk.redone.repository.DataRepo;
import dsk.redone.services.PrepareData;
import dsk.redone.services.XmlParser;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class InputDataTest {
    @Test
    public void firstIndexShouldLess2() {
        try {
            Method method = PrepareData.class.getDeclaredMethod("parseData", String.class);
            method.setAccessible(true);
            method.invoke(PrepareData.class, "31/12/2023");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setErTest() {
        String date="06/04/2024";
        String url = "https://cbr.ru/scripts/XML_dynamic.asp?date_req1="+date+"&date_req2="+date+"&VAL_NM_RQ=R01235";
        DataRepo repo = XmlParser.createXmlParser();
         repo.setErList(url);
        for(ExRate er:DataRepo.getErList()){
            assert(er!=null);
        }
    }
}
