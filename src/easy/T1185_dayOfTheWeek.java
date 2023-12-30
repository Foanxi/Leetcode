package easy;

import java.time.LocalDate;

public class T1185_dayOfTheWeek {

    private final String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return week[date.getDayOfWeek().getValue() % 7];
    }
}
