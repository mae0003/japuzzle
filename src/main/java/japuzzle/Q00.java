package japuzzle;


import java.util.Arrays;
import java.util.List;

public class Q00 extends Question {

	@Override
	public void solve() {
		Arrays.asList("aa","bb").forEach( str -> {
			System.out.println(str);
		}
		);
	}

}
