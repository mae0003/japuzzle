package japuzzle;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 問題インターフェースです。
 * 
 */
public abstract class Question {

	StopWatch stopWatch = new StopWatch();

	public void solveQuestion() {
		stopWatch.start();
		solve();
		stopWatch.stop();

		outputCurrentTime();
	}

	public void outputCurrentTime() {
		System.out.println(String.format("かかった時間は %,3d msec.", stopWatch.getTime()));
	}

	/**
	 * 問題を解きます。 このメソッドを継承して問題を回答してください。
	 */
	abstract protected void solve();
}
