public class DateTime {
    private int second;
    private int minute;
    private int hour;
    private int day;
    private int month;
    private int year;


    /**
     * DateTime(int, int, int) corresponds to standard mm/dd/yy date
     * format.
     * @throws Exception in case some or all of the parameters fall out
     * of the required range.
     */
    public DateTime(int year, int month, int day) throws Exception {
        if (validDate(month, day, year)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            throw new Exception("Invalid Date");
        }

    }

    /**
     * DateTime(int, int, int) corresponds to standard mm/dd/yy/hh/mm/ss
     * date and time format.
     * @throws Exception in case some or all of the parameters fall out
     * of the required range.
     */
    public DateTime(int year, int month, int day, int hour, int minute, int second) throws Exception {
        if (validDateTime(month, day, year, hour, minute, second)) {
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
