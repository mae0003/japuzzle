package japuzzle;

import java.util.stream.LongStream;

import org.apache.commons.lang3.StringUtils;

public class Q01ans2 extends Question {
	@Override
	public void solve() {

		final long START_NUMBER = 11;

		LongStream.range(START_NUMBER, 1000000000L).parallel()
				.filter(item -> {
					String sb10 = Long.toString(item);
					return sb10.equals(StringUtils.reverse(sb10));
				})
				.filter(item -> {
					String sb8 = Long.toOctalString(item);
					return sb8.equals(StringUtils.reverse(sb8));
				})
				.filter(item -> {
					String sb2 = Long.toBinaryString(item);
					return sb2.equals(StringUtils.reverse(sb2));
				})
				.forEach(item -> System.out.println(item));
	}
}
