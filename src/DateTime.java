import javax.swing.plaf.synth.SynthEditorPaneUI;

public class DateTime {
    private int second;
    private int minute;
    private int hour;
    private int day;
    private int month;
    private int year;


    /**
     * Constructor: DateTime(int, int, int)
     *
     * @param year
     * @param month
     * @param day
     * @throws Exception in case some or all of the parameters fall out
     * of the required range.
     * Description: Requires only the date portion, time is set to 00:00:00
     */
    public DateTime(int year, int month, int day) throws Exception {
        if (validDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = 0;
            this.minute = 0;
            this.second = 0;
        } else {
            throw new Exception("Invalid Date");
        }

    }

    /**
     * Constructor: DateTime(int, int, int)
     *
     * @param year
     * @param month
     * @param day
     * @param hour   Transformed into string through formatHour method
     * @param minute Transformed into string through formatMinute method
     * @param second Transformed into string through formatSecond method
     * @throws Exception in case some or all of the parameters fall out
     * of the required range.
     * Description: Requires both the date and the time portion. Time is
     * converted into string through formatXXXX methods
     */
    public DateTime(int year, int month, int day, int hour, int minute, int second) throws Exception {
        if (validDateTime(year, month, day, hour, minute, second)) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        } else {
            throw new Exception("Invalid DateTime");
        }
    }

    /**
     * Method: isThirtyOneDayMonth
     *
     * @param month
     * @return boolean
     * Description: Returns true if the @param month is one
     * of the months that has 31 days.
     */
    public static boolean isThirtyOneDayMonth(int month) {
        return month == 1 || month == 3 || month == 5 || month == 8 || month == 10 || month == 12;
    }

    /**
     * Method: isThirtyDayMonth
     *
     * @param month
     * @return boolean
     * Description: Returns true if the @param month is one
     * of the months that has 30 days.
     */
    public static boolean isThirtyDayMonth(int month) {
        return month == 4 || month == 6 || month == 9 || month == 11;
    }

    /**
     * Method: isDecember
     *
     * @param month
     * @return boolean
     * Description: Returns true if the @param month is the 12th
     * month, december.
     * .
     */
    public static boolean isDecember(int month) {
        return month == 12;
    }

    /**
     * Method: isFebruary
     *
     * @param month
     * @return boolean
     * Description: Returns true if the @param month is the 2nd
     * month, february
     */
    public static boolean isFebruary(int month) {
        return month == 2;
    }

    /**
     * Method: isLeapYear
     *
     * @param year
     * @return boolean
     * Description: Returns true if the @param year is a leap year
     * Algorithm:
     * if (year is not divisible by 4) then (it is a common year)
     * else if (year is not divisible by 100) then (it is a leap year)
     * else if (year is not divisible by 400) then (it is a common year)
     * else (it is a leap year)
     */
    public static boolean isLeapYear(int year) {
        if ((year % 4) != 0)
            return false;
        else if ((year % 100) != 0)
            return true;
        else if ((year % 400) != 0)
            return false;
        else
            return false;
    }


    /**
     * Method: toString
     *
     * @return String
     * Description: Returns the formatted form of the DateTime class.
     */
    @Override
    public String toString() {
        String monthString = formatMonth(month);
        String dayString = formatDay(day);
        String hourString = formatHour(hour);
        String minuteString = formatMinute(minute);
        String secondString = formatSecond(second);
        return monthString + "/" + dayString + "/" + year + " " + hourString + ":" + minuteString + ":" + secondString;
    }

    /**
     * Method: formatMonth
     *
     * @param month An int representation of the month attribute
     * @return String
     * Description: Returns the formatted form of the hour attribute.
     * If it has less than two digits, adds a 0 in front.
     */
    private String formatMonth(int month) {
        String monthString = String.valueOf(month);

        if (monthString.length() < 2) {
            return "0" + this.month;
        } else {
            return monthString;
        }
    }

    /**
     * Method: formatDay
     *
     * @param day An int representation of the month attribute
     * @return String
     * Description: Returns the formatted form of the hour attribute.
     * If it has less than two digits, adds a 0 in front.
     */
    private String formatDay(int day) {
        String dayString = String.valueOf(day);


        if (dayString.length() < 2) {
            return "0" + this.day;
        } else {
            return dayString;
        }
    }

    /**
     * Method: formatHour
     *
     * @param hour An int representation of the hour attribute
     * @return String
     * Description: Returns the formatted form of the hour attribute.
     * If it has less than two digits, adds a 0 in front.
     */
    private String formatHour(int hour) {
        String hourString = String.valueOf(hour);

        if (hourString.length() < 2) {
            return "0" + this.hour;
        } else {
            return hourString;
        }
    }

    /**
     * Method: formatMinute
     *
     * @param minute An int representation of the minute attribute
     * @return String
     * Description: Returns the formatted form of the minute attribute.
     * If it has less than two digits, adds a 0 in front.
     */
    private String formatMinute(int minute) {
        String minuteString = String.valueOf(minute);

        if (minuteString.length() < 2) {
            return "0" + this.minute;
        } else {
            return minuteString;
        }
    }

    /**
     * Method: formatHour
     *
     * @param second An int representation of the second attribute
     * @return String
     * Description: Returns the formatted form of the minute attribute.
     * If it has less than two digits, adds a 0 in front.
     */
    private String formatSecond(int second) {
        String secondString = String.valueOf(second);

        if (secondString.length() < 2) {
            return "0" + this.second;
        } else {
            return secondString;
        }
    }

    /**
     * Method: validDate
     *
     * @param year
     * @param month
     * @param day
     * @return boolean
     * Description: Returns true if the parameters supplied
     * are valid values for year, month and date attributes.
     */
    private static boolean validDate(int year, int month, int day) {
        if (day < 1 || month < 1 || month > 12 || year < 0 || year > 9999)
            return false;

        if (isThirtyOneDayMonth(month) || isDecember(month)) {
            if (day > 31) return false;
        }

        if (isThirtyDayMonth(month)) {
            if (day > 30) return false;
        }

        if (isFebruary(month)) {
            if (isLeapYear(year)) {
                if (day > 29) return false;

            } else {
                if (day > 28) return false;
            }

        }

        return true;
    }


    /**
     * Method: validDateTime
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @return boolean
     * Description: Returns true if the parameters supplied
     * are valid values for year, month, date, hour, minute and second
     * attributes.
     */
    private static boolean validDateTime(int year, int month, int day, int hour, int minute, int second) {
        if(validDate(year,month,day)){
            if (hour < 0 || hour > 24)
                return false;
            else if (minute < 0 || minute > 60) {
                return false;
            }
            else if (second < 0 || second > 60) {
                return false;
            }
        }else {
            return false;
        }

        return true;
    }

    /**
     * Method: addDays
     *
     * @param numberOfDays A number of days to add
     * @return String
     * Description: Add the desired number of days to the
     * instance variable day.
     */
    public String addDays(int numberOfDays){
        if(numberOfDays > 0) {
            int incrementedDay = this.day + numberOfDays;

            if (isThirtyDayMonth(month)) {
                if (incrementedDay > 30) {
                    while (incrementedDay > 30) {
                        incrementedDay -= 30;
                        addMonths(1);
                    }
                }
            }

            if (isThirtyOneDayMonth(month)) {
                if (incrementedDay > 31) {
                    while (incrementedDay > 31) {
                        incrementedDay -= 31;
                        addMonths(1);
                    }
                }
            }

            if (isFebruary(month)) {
                if (isLeapYear(year)) {
                    if (incrementedDay > 29) {
                        while ((incrementedDay > 29)) {
                            incrementedDay -= 29;
                            addMonths(1);
                        }
                    }
                } else {
                    if (incrementedDay > 28) {
                        while ((incrementedDay > 28)) {
                            incrementedDay -= 28;
                            addMonths(1);
                        }
                    }
                }
            }

            this.day = incrementedDay;
        }
        else {
            System.out.println("Number of days can't be negative");
            return null;
        }
        return this.toString();
    }


    /**
     * Method: addMonths
     *
     * @param numberOfMonths A number of months to add
     * @return String
     * Description: Add the desired number of months to the
     * instance variable month.
     */
    public String addMonths(int numberOfMonths){
        if(numberOfMonths > 0) {
            int incrementedMonth = month + numberOfMonths;

            if (incrementedMonth > 12){
                while ((incrementedMonth > 12)) {
                    incrementedMonth -= 12;
                    addYears(1);
                }
            }
            this.month = incrementedMonth;
        } else {
            System.out.println("Number of months can't be negative");
            return null;
        }
        return this.toString();
    }



    /**
     * Method: addYears
     *
     * @param numberOfYears A number of years to add
     * @return String
     * Description: Add the desired number of years to the
     * instance variable years.
     */
    public String addYears(int numberOfYears){
        if(numberOfYears > 0 && (year + numberOfYears) < 9999 ) {
            int incrementedYear = year + numberOfYears;
            this.year = incrementedYear;
        } else {
            System.out.println("Number of years can't be negative");
            return null;
        }
        return this.toString();
    }

    /**
     * Method: addHours
     *
     * @param numberOfHours A number of months to add
     * @return String
     * Description: Add the desired number of hours to the
     * instance variable hours.
     */
    public String addHours(int numberOfHours){
        if(numberOfHours > 0) {
            int incrementedHour = hour + numberOfHours;

            if (incrementedHour > 24){
                while ((incrementedHour > 24)) {
                    incrementedHour -= 24;
                    addDays(1);
                }
            }
            this.hour = incrementedHour;
        } else {
            System.out.println("Number of hours can't be negative");
            return null;
        }
        return this.toString();
    }



    /**
     * Getters and setters
     *
     */

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
