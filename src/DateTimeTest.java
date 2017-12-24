import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeTest {

    @Test
    void DateTimeTest() {
        try {
            DateTime date = new DateTime(2012, 12, 21);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void toStringDateTest(){
        try {
            DateTime date = new DateTime(2012, 12, 21);
            assertEquals("12/21/2012 00:00:00", date.toString());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}