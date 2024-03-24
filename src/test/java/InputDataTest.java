import dsk.redone.controllers.WebInputData;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class InputDataTest {
@Test
    public void firstIndexShouldLess2(){
    try {
        Method method = WebInputData.class.getDeclaredMethod("parseDate", String.class);
        method.setAccessible(true);
        method.invoke(WebInputData.class,"31/12/2023");

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
