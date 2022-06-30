import java.util.HashMap;

/**
 * @author zhengyumin
 * @description 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * @date 2020-08-12 8:52 PM
 */
public class EditDistance {

    /**
     * 两个指针,i,j 分别指向两个字符串的最后，然后一步步往前走，缩小问题的规模
     * if s1[i] == s2[j]:
     * 啥都别做（skip）
     * i, j 同时向前移动
     * else:
     * 三选一：
     * 插入（insert）
     * 删除（delete）
     * 替换（replace）
     *
     * @param args
     */
    public static void main(String[] args) {

        String word1 = "intention";
        String word2 = "execution";

//        int ans = solution(word1, word2);


        EditDistance demo = new EditDistance();
        int ans = demo.minDistance(word1, word2);

        System.out.println(ans);

    }


    /**
     * 动态规划
     * @param s1
     * @param s2
     * @return
     */
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        //bad case
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1), dp[i][j - 1] + 1);
                }
            }
        }
        return dp[m][n];

    }


    static ThreadLocal<HashMap<String, String>> local = new ThreadLocal();


    private static int solution(String word1, String word2) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("word1", word1);
        map.put("word2", word2);
        local.set(map);


        return dp(word1.length() - 1, word2.length() - 1);
    }

    private static int dp(int i, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }

        if (local.get().get("word1").charAt(i) == local.get().get("word2").charAt(j)) {
            return dp(i - 1, j - 1);
        } else {
            return Math.min(dp(i - 1, j - 1) + 1,
                    Math.min(dp(i, j - 1) + 1, dp(i - 1, j) + 1));
        }
    }
}
