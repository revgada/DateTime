public class DateTime {
    private String second;
    private String minute;
    private String hour;
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
            this.hour = formatHour(hour);
            this.minute = formatMinute(minute);
            this.second = formatSecond(second);
        } else {
            throw new Exception("Invalid DateTime");
        }
    }

    public String toString() {
        return month + "/" + day + "/" + year + " " + hour + ":" + minute + ":" + second;
    }

    private String formatHour(int hour){
        this.hour = String.valueOf(hour);

        if(this.hour.length() < 2){
            return "0" + this.hour;
        }
        else{
            return this.hour;
        }
    }

    private String formatMinute(int minute){
        this.minute = String.valueOf(minute);
        if(this.minute.length() < 2){
            return "0" + this.minute;
        }
        else{
            return this.minute;
        }
    }

    private String formatSecond(int second){
        this.second = String.valueOf(second);
        if(this.second.length() < 2){
            return "0" + this.second;
        }
        else{
            return this.second;
        }
    }

    private boolean validDate(int year, int month, int day){
        if(year > 9999) {
            return false;
        }
        else if(month > 12){
            return false;
        }
        else if(day > 31){
            return false;
        }
        return true;
    }

    private boolean validDateTime(int year, int month, int day, int hour, int minute, int second){
        if(year > 9999) {
            return false;
        }
        else if(month > 12){
            return false;
        }
        else if(day > 31){
            return false;
        }
        else if(hour > 24) {
            return false;
        }
        else if(minute > 60) {
            return false;
        }
        else if(second > 60) {
            return false;
        }
        return true;
    }

}
