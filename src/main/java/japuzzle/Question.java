package japuzzle;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 問題の基底クラスです。 このクラスを継承して solve() メソッドで問題を解いてください。
 * 
 * 
 * 
 */
public abstract class Question {

    public Question() {
    }

    StopWatch stopWatch = new StopWatch();

    public void solveQuestion() {
        stopWatch.start();
        solve();
        stopWatch.stop();

        outputCurrentTime();
    }

    public void outputCurrentTime() {
        System.out.println(String.format("[終了時間: %,8d msec]", stopWatch.getTime()));
    }

    protected void logout(String message) {
        System.out.println(String.format("[経過時間: %,8d msec] " + message, stopWatch.getTime()));
    }

    /**
     * 問題を解きます。 このメソッドを継承して問題を回答してください。
     */
    abstract protected void solve();
}
