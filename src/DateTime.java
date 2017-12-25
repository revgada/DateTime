public class DateTime {
    private String second;
    private String minute;
    private String hour;
    private String day;
    private String month;
    private String year;


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
            this.hour = "00";
            this.minute = "00";
            this.second = "00";
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
            this.hour = formatHour(hour);
            this.minute = formatMinute(minute);
            this.second = formatSecond(second);
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
        return month == 1 || month == 3 || month == 5 || month == 8 || month == 10;
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
        return month + "/" + day + "/" + year + " " + hour + ":" + minute + ":" + second;
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
        this.hour = String.valueOf(hour);

        if (this.hour.length() < 2) {
            return "0" + this.hour;
        } else {
            return this.hour;
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
        this.minute = String.valueOf(minute);
        if (this.minute.length() < 2) {
            return "0" + this.minute;
        } else {
            return this.minute;
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
        this.second = String.valueOf(second);
        if (this.second.length() < 2) {
            return "0" + this.second;
        } else {
            return this.second;
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

    public String addDays(int numberOfDays){
        int incrementedDays = this.day + numberOfDays;
        if (DateTime.validDate(this.year,this.month,incrementedDays)){
            this.day = incrementedDays;
        }
        return this.toString();
    }


    /**
     * Getters and setters
     *
     */

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
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
