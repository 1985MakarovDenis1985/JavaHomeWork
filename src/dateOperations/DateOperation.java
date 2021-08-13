package dateOperations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class DateOperation {

    public static String[] sortStringDates(String[] dates) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Arrays.sort(dates, (s1, s2) -> {
            if (s1.matches("\\d{4}-\\d{2}-\\d{2}") && s2.matches("\\d{2}/\\d{2}/\\d{4}")){
               return LocalDate.parse(s1, formatter).compareTo(LocalDate.parse(s2, formatter2));
            }
            if (s1.matches( "\\d{2}/\\d{2}/\\d{4}") && s2.matches("\\d{4}-\\d{2}-\\d{2}")){
               return LocalDate.parse(s1, formatter2).compareTo(LocalDate.parse(s2, formatter));
            }
            return s1.compareTo(s2);
        });
        return dates;
    }


    public static int getAge(String date) {
        LocalDate currentDate = LocalDate.now();
        if (date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return (int) ChronoUnit.YEARS.between(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")), currentDate);
        }
        return (int) ChronoUnit.YEARS.between(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")), currentDate);
    }
}
