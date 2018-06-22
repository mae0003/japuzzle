package japuzzle;

import org.apache.commons.lang3.StringUtils;

public class Q01ans extends Question {

    final long START_NUMBER = 11;

    @Override
    protected void solve() {
        for (Long i = 11L; i < 1000000000L; i++) {
            if (isPalindromicNumber(i)) {
                logout("回文数は :" + Long.toString(i));
            }
        }
    }

    private boolean isPalindromicNumber(Long num) {
        String sb10 = Long.toString(num);
        String sb8 = Long.toOctalString(num);
        String sb2 = Long.toBinaryString(num);
        
        return sb10.equals(StringUtils.reverse(sb10)) && sb8.equals(StringUtils.reverse(sb8))
                && sb2.equals(StringUtils.reverse(sb2));
    }
}
