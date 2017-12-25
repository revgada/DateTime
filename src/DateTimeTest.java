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

    @Test
    void validDate31dayMonthTest(){
        try {
            DateTime date = new DateTime(2012, 1, 32);
            assertEquals("Invalid Date", date.toString());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void validDateTime30dayMonthInvalidDateTest(){
        try {
            DateTime dateTime = new DateTime(2012, 4, 31, 13, 12, 32);
            assertEquals("Invalid DateTIme", dateTime.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void isThirtyOneDayMonthTest(){
        try {
            assertEquals(true, DateTime.isThirtyOneDayMonth(1));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void isDecemberTest(){
        try { ;
            assertEquals(true, DateTime.isDecember(12));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void isThirtyDayMonthTest(){
        try {
            assertEquals(true, DateTime.isThirtyDayMonth(4));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void isFebruaryTest(){
        try {
            assertEquals(true, DateTime.isFebruary(2));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void isLeapYear(){
        try {
            assertEquals(true, DateTime.isLeapYear(1940));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}