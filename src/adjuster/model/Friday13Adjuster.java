package adjuster.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Friday13Adjuster implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
//        LocalDate date = LocalDate.now();
//        date = date.withYear(2025);
//        date = date.withMonth(3);
//        date = date.withDayOfMonth(28);
//        date = date.withDayOfYear(256);
//        System.out.println(date);
//
//        date = date.with(ChronoField.YEAR, 2022); // какое поле на что изменить
//        System.out.println(date);
//
//        date = date.with(TemporalAdjusters.firstDayOfNextMonth());
//        System.out.println(date);
//        date = date.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
//        System.out.println(date);
//        date = date.with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.FRIDAY)); // 4 пятница в этом месяце
//        System.out.println(date);

//        LocalDate ls = LocalDate.from(temporal);
//        System.out.println(ls);
        LocalDate ld = LocalDate.from(temporal);
        while ((ld.getDayOfWeek() == DayOfWeek.FRIDAY && ld.getDayOfMonth() == 13) != true) {
            ld = ld.plusDays(1);
        }
//        for loop
//        for (int i = temporal.get(ChronoField.DAY_OF_YEAR); i < 500; i++) {
//            ld = ld.plusDays(1);
//            if ( ld.getDayOfWeek() == DayOfWeek.FRIDAY && ld.getDayOfMonth() == 13) {
//                return ld;
//            }
//        }
        return ld;
    }
}
