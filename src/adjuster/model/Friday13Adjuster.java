package adjuster.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.*;

public class Friday13Adjuster implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        while ((temporal.get(ChronoField.DAY_OF_WEEK) == 5 && temporal.get(ChronoField.DAY_OF_MONTH) == 13) != true) {
               temporal = temporal.plus(1, ChronoUnit.DAYS);
        }
        return temporal;
    }
}
