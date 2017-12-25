import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeTest {

    @Test
    void DateWrongYearTest() {
        try {
            DateTime date = new DateTime(100000, 12, 21);
        } catch (Exception e) {
            assertEquals("Invalid Date", e.getMessage());
        }
    }

    @Test
    void DateWrongMonthTest() {
        try {
            DateTime date = new DateTime(2012, 17, 21);
        } catch (Exception e) {
            assertEquals("Invalid Date", e.getMessage());
        }
    }

    @Test
    void DateWrongDayTest() {
        try {
            DateTime date = new DateTime(100000, 12, 7777);
        } catch (Exception e) {
            assertEquals("Invalid Date", e.getMessage());
        }
    }

    @Test
    void DateTimeWrongHourTest(){
        try{
            DateTime dateTime = new DateTime(2012, 12, 21, 66, 21, 32);
        }catch (Exception e){
            assertEquals("Invalid DateTime", e.getMessage());
        }
    }

    @Test
    void DateTimeWrongMinuteTest(){
        try{
            DateTime dateTime = new DateTime(2012, 12, 21, 14, 100000, 32);
        }catch (Exception e){
            assertEquals("Invalid DateTime", e.getMessage());
        }
    }

    @Test
    void DateTimeWrongSecondTest(){
        try{
            DateTime dateTime = new DateTime(2012, 12, 21, 14, 21, 10000);
        }catch (Exception e){
            assertEquals("Invalid DateTime", e.getMessage());
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
    void toStringDateTimeTest(){
        try {
            DateTime dateTime = new DateTime(2012,12,21,12,45,13);
            assertEquals("12/21/2012 12:45:13", dateTime.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addDaysDecember31Test(){
        try {
            DateTime dateTime = new DateTime(2012,12,22,12,45,13);
            assertEquals("01/01/2012 12:45:13", dateTime.addDays(10));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addDays30DayMonthTest(){
        try {
            DateTime dateTime = new DateTime(2012,4,21,12,45,13);
            assertEquals("05/01/2012 12:45:13", dateTime.addDays(10));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addDaysFebruaryNoLeapYearTest(){
        try {
            DateTime dateTime = new DateTime(2011,2,28,12,45,13);
            assertEquals("03/01/2011 12:45:13", dateTime.addDays(1));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addDaysFebruaryLeapYearTest(){
        try {
            DateTime dateTime = new DateTime(2011,2,28,12,45,13);
            assertEquals("02/29/2011 12:45:13", dateTime.addDays(1));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /** =============================================================================================
     * Helper Tests
     *  =============================================================================================
     */
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