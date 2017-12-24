public class DateTime {
    private int second;
    private int minute;
    private int hour;
    private int day;
    private int month;
    private int year;

    public DateTime(int month, int day, int year) throws Exception {
        if (validDate(month, day, year)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            throw new Exception("Invalid Date");
        }

    }


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
}
