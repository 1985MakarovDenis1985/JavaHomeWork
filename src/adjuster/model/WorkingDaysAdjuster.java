package adjuster.model;

import java.time.DayOfWeek;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class WorkingDaysAdjuster implements TemporalAdjuster {
	int nDays;
	DayOfWeek[] daysOff;

	public WorkingDaysAdjuster(int nDays, DayOfWeek[] daysOff) {
		this.nDays = nDays;
		this.daysOff = daysOff;
	}

	@Override
	public Temporal adjustInto(Temporal temporal) {
		// TODO Auto-generated method stub
		return null;
	}

}
