import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String date = "2002-11-29 11:30:29";
        String sub = date.substring(0,date.indexOf(' '));
        System.out.println(sub);

        System.out.println(Pattern.matches("^\\d{4}/\\d+/\\+$",sub));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = dateFormat.parse(sub);
            System.out.println(date1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
