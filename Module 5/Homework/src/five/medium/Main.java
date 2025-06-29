package five.medium;

import five.easy.DayOfWeek;

import java.util.List;

public class Main {

    private static final List<DayOfWeek> DAYS = DayOfWeek.getDaysOfWeek();

    public static void main(String[] args) {
        printDays();
        System.out.println("Is it weekend : " + isWeekend(DayOfWeek.SATURDAY));
    }

    public static boolean isWeekend(DayOfWeek day) {
        return DayOfWeek.SATURDAY.equals(day) || DayOfWeek.SUNDAY.equals(day);
    }

    public static void printDays() {
        for (DayOfWeek days : DAYS) {
            System.out.println(days);
        }
    }
}
