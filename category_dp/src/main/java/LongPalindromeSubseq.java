/**
 * @author zhengyumin
 * @description 最长回文子序列的长度
 * <p>
 * 输入:"bbbab"
 * 输出:4
 * 解释  最长回文子序列 "bbbb"
 *
 * @date 2020-10-14 9:05 PM
 */
public class LongPalindromeSubseq {


    public static void main(String[] args) {
        String s = "bbbab";
        LongPalindromeSubseq demo = new LongPalindromeSubseq();
        System.out.println(demo.solution(s));

    }


    /**
     * 在子串s[i..j]中，最长回文子序列的长度为dp[i][j]。
     * <p>
     * i i+1        j-1 j
     * ? b   b a b  a   ?
     * <p>
     * 假设  dp[i+1][j-1] =3
     * s[i]==s[j]
     * 则 dp[i][j] = 3+2;
     *
     *  参考：https://mp.weixin.qq.com/s/zNai1pzXHeB2tQE6AdOXTA
     * @param s
     * @return
     */
    public int solution(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        //bad case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        //确定遍历方向
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    //s[i+1...j] 和 s[i...j-1] 谁的回文子序列更长
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[0][n - 1];
    }

}
