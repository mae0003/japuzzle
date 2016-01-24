package japuzzle;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

public class Q07 extends Question {

	static SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");

	@Override
	public void solve() {
		Calendar currentCalendar = Calendar.getInstance();
		currentCalendar.set(1964, 10, 10);

		Calendar endCalendar = Calendar.getInstance();
		endCalendar.set(2020, 7, 24);

		while (true) {
			String dateStr = dateFormat.format(currentCalendar.getTime());

			currentCalendar.add(Calendar.DATE, 1);

			int intVal = Integer.parseInt(dateStr);
			String binaryStr = Integer.toBinaryString(intVal);

			if (intVal == Integer.parseInt(StringUtils.reverse(binaryStr), 2)) {
				System.out.println(dateStr);
			}

			if (currentCalendar.equals(endCalendar))
				break;
		}
	}
}
