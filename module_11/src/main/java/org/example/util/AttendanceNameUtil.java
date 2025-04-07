package org.example.util;

public class AttendanceNameUtil {

    private static final String VALUE_IS_ATTENDED = "Да";
    private static final String VALUE_IS_NOT_ATTENDED = "Нет";

    public static boolean fromStringToBoolean(String attendance) {
        return VALUE_IS_ATTENDED.equalsIgnoreCase(attendance);
    }

    public static String fromBooleanToString(boolean isAttended) {
        if (isAttended) {
            return VALUE_IS_ATTENDED;
        }
        return VALUE_IS_NOT_ATTENDED;
    }
}
