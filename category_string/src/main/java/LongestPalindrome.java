/**
 * @author zhengyumin
 * @description https://leetcode-cn.com/problems/longest-palindromic-substring/
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * @date 2020-07-07 3:52 PM
 */
public class LongestPalindrome {

    /**
     * 实现思路:
     * 1.双指针向两边展开（ 注意单数和复数）
     * 2.动态规划 P(i,j)=P(i+1,j−1)∧(Si ==Sj)
     *
     * @param args
     */
    public static void main(String[] args) {

        String inputStr = "babad";


        System.out.println(solution1(inputStr));

    }


    /**
     * 双指针
     * @param s
     * @return
     */
    public static String solution1(String s) {
        //bad case
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int max = Math.max(len1, len2);
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expand(String source, int l, int r) {
        while (l >= 0 && r < source.length() && source.charAt(l) == source.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }


//    public int countSubstrings(String s) {
//        //dp[i][j] = (nums[i]==nums[j] && dp[i+1][j-1])
//
//        int n = s.length();
//        char []nums = s.toCharArray();
//        boolean [][]dp = new boolean[n][n];
//
//        int ans=n;
//        for(int i=n-1;i>=0;i--){
//            for(int j=i+1;j<n;j++){
//                dp[i][j] = (nums[i]==nums[j] && (j-i<=2||dp[i+1][j-1]) && ans++>0);
//            }}
//
//        return ans;
//    }


    /**
     * 动态规划
     * @param s
     * @return
     */
    public String solution2(String s) {
        char[] nums = s.toCharArray();
        int sSize = s.length();
        if (sSize == 0 || sSize == 1) {
            return s;
        }
        String result = "";
        boolean dp[][] = new boolean[sSize][sSize];
        int start = 0, end = 0, maxLen = 0;
        //动态规划 dp[i][j]
        for (int j = 0; j < sSize; j++) {
            for (int i = 0; i <= j; i++) {
                //长度为1，2的情况单独考虑
                dp[i][j] = (j - i <= 2 || dp[i + 1][j - 1]) && (s.charAt(i) == s.charAt(j));
                if (dp[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        for (int i = start; i <= end; i++) {
            result += s.charAt(i);
        }

        return result;
    }


}
