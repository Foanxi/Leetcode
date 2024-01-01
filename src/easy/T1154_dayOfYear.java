package easy;

public class T1154_dayOfYear {

    private final int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        String[] dateSplit = date.split("-");
        int month = Integer.parseInt(dateSplit[1]);
        int day = isPear(Integer.parseInt(dateSplit[0])) && month > 2 ? 1 : 0;
        for (int i = 0; i < month; i++) {
            day += dayOfMonth[i];
        }
        return day + Integer.parseInt(dateSplit[2]);
    }

    public boolean isPear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
