import java.text.SimpleDateFormat;
import java.util.Date;

interface DateFormatter {
    static String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
}

public class DateFormatDemo {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(DateFormatter.format(now, "dd/MM/yyyy"));
        System.out.println(DateFormatter.format(now, "yyyy-MM-dd"));
    }
}
