package dateOperations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class DateOperation {

    public static String[] sortStringDates(String[] dates) {
        DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter_2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Arrays.sort(dates, (el_1, el_2) -> {
            if (el_1.matches("\\d{4}-\\d{2}-\\d{2}") && el_2.matches("\\d{2}/\\d{2}/\\d{4}")){
               return LocalDate.parse(el_1, formatter_1).compareTo(LocalDate.parse(el_2, formatter_2));
            }
            if (el_1.matches( "\\d{2}/\\d{2}/\\d{4}") && el_2.matches("\\d{4}-\\d{2}-\\d{2}")){
               return LocalDate.parse(el_1, formatter_2).compareTo(LocalDate.parse(el_2, formatter_1));
            }
            return LocalDate.parse(el_1).compareTo(LocalDate.parse(el_2));
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
