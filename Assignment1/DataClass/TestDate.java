public class TestDate {
    public static void main(String[] args) {
        Date date = new Date(2022, 1, 1);

        // the day I did this assignment
        date.setDate(2022, 3, 8);
        date.addOneDay();
        date.display();

        // illegal date
        date.setDate(2022, 2, 29);

        // the last day of Feb in common year
        date.setDate(2022, 2, 28);
        date.addOneDay();
        date.display();

        // the last day of Feb in leap year
        date.setDate(2020, 2, 28);
        date.addOneDay();
        date.display();

        // the last day of 2022
        date.setDate(2022,12,31);
        date.addOneDay();
        date.display();

        // oop is AWESOME!
    }
}
