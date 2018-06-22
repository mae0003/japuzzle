package japuzzle;

import java.util.stream.LongStream;

import org.apache.commons.lang3.StringUtils;

public class Q01ansThread extends Question {

	@Override
	public void solve() {

		final long START_NUMBER = 11;

		LongStream.range(START_NUMBER, 100_000_000_000L).parallel().forEach(i -> {

			String sb10 = Long.toString(i);
			String sb8 = Long.toOctalString(i);
			String sb2 = Long.toBinaryString(i);

			if (sb10.equals(StringUtils.reverse(sb10)) &&
					sb8.equals(StringUtils.reverse(sb8)) &&
					sb2.equals(StringUtils.reverse(sb2))) {
				logout(sb10 + ", " + sb8 + ", " + sb2);
			}
		});
	}
}