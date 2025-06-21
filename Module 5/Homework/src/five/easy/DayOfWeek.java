package five.easy;

import java.util.Arrays;
import java.util.List;

public enum DayOfWeek {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static List<DayOfWeek> getDaysOfWeek() {
        return Arrays.asList(values());
    }
}
