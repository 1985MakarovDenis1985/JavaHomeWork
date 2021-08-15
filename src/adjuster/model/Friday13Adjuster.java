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
        LocalDate ld = LocalDate.now();
        LocalDate ls = LocalDate.now();

        for (int i = temporal.get(ChronoField.DAY_OF_YEAR); i < 500; i++) {
            ld = ld.plusDays(1);
            if ( ld.getDayOfWeek() == DayOfWeek.FRIDAY && ld.getDayOfMonth() == 13) {
                System.out.println(ld);
                return ld;
            }
        }


//		int temp = year + 6;
//		System.out.println(date);

        return LocalDate.now();
    }

//	DateTime date = DateTime.Now; // as today is 13th. If system date changes then hardcode date.
//
//while (date < <Some date in the future you want to report to>)
//	{
//		date = date.AddMonths(1);
//		if (date.DayOfWeek == DayOfWeek.Friday)
//			System.Console.PrintLine(date.ToString());
//	}

}
