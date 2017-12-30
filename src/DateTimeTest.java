import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeTest {

    /** ==============================================================================================
     *  Constructor tests
     *  ==============================================================================================
     */

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

    /** ==============================================================================================
     *  toString tests
     *  ==============================================================================================
     */


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

    /** ================================================================================================
     *  addDays tests
     *  ================================================================================================
     */

    @Test
    void addDaysDecember31Test(){
        try {
            DateTime dateTime = new DateTime(2012,12,22,12,45,13);
            assertEquals("01/01/2013 12:45:13", dateTime.addDays(10));
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
            DateTime dateTime = new DateTime(2020,2,28,12,45,13);
            assertEquals("02/29/2020 12:45:13", dateTime.addDays(1));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /** ==============================================================================================
     *  addMonths Tests
     *  ==============================================================================================
     */

    @Test
    void addMonthsDecemberTest(){
        try {
            DateTime dateTime = new DateTime(2011,12,28,12,45,13);
            assertEquals("01/28/2012 12:45:13", dateTime.addMonths(1));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addMonthsJanuaryTest(){
        try {
            DateTime dateTime = new DateTime(2012,1,28,12,45,13);
            assertEquals("05/28/2012 12:45:13", dateTime.addMonths(4));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addMonthsMoreThan12MonthsTest(){
        try {
            DateTime dateTime = new DateTime(2012,1,28,12,45,13);
            assertEquals("02/28/2013 12:45:13", dateTime.addMonths(13));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /** ==============================================================================================
     *  addYears Tests
     *  ==============================================================================================
     */

    @Test
    void addYearNoErrorTest(){
        try {
            DateTime dateTime = new DateTime(2012,1,28,12,45,13);
            assertEquals("01/28/2022 12:45:13", dateTime.addYears(10));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addYearOver9999Test(){
        try {
            DateTime dateTime = new DateTime(2012,1,28,12,45,13);
            assertNull(dateTime.addYears(10000000));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /** ==============================================================================================
     *  addHours Tests
     *  ==============================================================================================
     */

    @Test
    void addHoursNegativeTest(){
        try {
            DateTime dateTime = new DateTime(2011,12,28,12,45,13);
            assertNull(dateTime.addHours(-6));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addHoursLessThan24Test(){
        try {
            DateTime dateTime = new DateTime(2012,1,28,12,45,13);
            assertEquals("01/28/2012 22:45:13",dateTime.addHours(10));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addHoursMoreThan24Test(){
        try {
            DateTime dateTime = new DateTime(2012,1,31,12,45,13);
            assertEquals("02/01/2012 22:45:13", dateTime.addHours(34));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /** ==============================================================================================
     *  addMinutes Tests
     *  ==============================================================================================
     */

    @Test
    void addMinutesNegativeTest(){
        try {
            DateTime dateTime = new DateTime(2011,12,28,12,45,13);
            assertNull(dateTime.addMinutes(-6));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addMinutesLessThan60Test(){
        try {
            DateTime dateTime = new DateTime(2012,1,28,12,45,13);
            assertEquals("01/28/2012 12:55:13",dateTime.addMinutes(10));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addMinutesMoreThan60Test(){
        try {
            DateTime dateTime = new DateTime(2012,1,28,12,45,13);
            assertEquals("01/28/2012 13:55:13", dateTime.addMinutes(70));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /** =============================================================================================
     *  Helper Tests
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