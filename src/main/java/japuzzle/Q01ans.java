package japuzzle;

import org.apache.commons.lang3.StringUtils;

public class Q01ans extends Question {

	final long START_NUMBER = 11;

	@Override
	protected void solve() {

		for (Long i = 11L; i < 1000000000L; i++) {

			String sb10 = Long.toString(i);
			String sb8 = Long.toOctalString(i);
			String sb2 = Long.toBinaryString(i);

			if (sb10.equals(StringUtils.reverse(sb10)) &&
					sb8.equals(StringUtils.reverse(sb8)) &&
					sb2.equals(StringUtils.reverse(sb2))) {
				System.out.println(sb10 + ", " + sb8 + ", " + sb2);

			}
		}
	}

}
