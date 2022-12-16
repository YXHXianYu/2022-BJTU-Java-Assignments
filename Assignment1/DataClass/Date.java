public class Date {
    private int year;
    private int month;
    private int day;

    private int[] dayPerMonth     = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int[] dayPerMonthLeap = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int year, int month, int day) {
        if(!isLegalDate(year, month, day)) {
            this.year = 2022;
            this.month = 1;
            this.day = 1;
            showErrorMessage();
            return;
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void setDate(int year, int month, int day) {
        if(!isLegalDate(year, month, day)) {
            showErrorMessage();
            return;
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void addOneDay() {
        day++;
        if( (isLeapYear(year) && day > dayPerMonthLeap[month])
                || (!isLeapYear(year) && day > dayPerMonth[month]) ) {
            month++;
            day = 1;
        }
        if(month > 12) {
            year++;
            month = 1;
        }
    }
    public void display() {
        System.out.println("The date is " + day + "/" + month + "/" + year + ".");
        System.out.println(" ");
    }

    private boolean isLegalDate(int year, int month, int day) {
        if(year < 0) return false;
        if(month < 1 || month > 12) return false;
        if(day < 1) return false;

        if(isLeapYear(year)) {
            if(day > dayPerMonthLeap[month]) return false;
            else return true;
        } else {
            if(day > dayPerMonth[month]) return false;
            else return true;
        }
    }
    private boolean isLeapYear(int year) {
        if(year < 0) return false;
        if(year % 100 == 0)
            return year % 400 == 0;
        else
            return year % 4 == 0;
    }

    private void showErrorMessage() {
        System.out.println("The date is illegal!");
        System.out.println("The date will set to 2022/1/1 if error occurs when initialization.");
        System.out.println(" ");
    }
}
