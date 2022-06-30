/**
 * @author zhengyumin
 * @description 输入: str1 = "abcde", str2 = "ace"
 * 输出: 3
 * 解释: 最长公共子序列是 "ace"，它的长度是 3
 * @date 2020-10-14 8:51 PM
 */
public class LCS {

    public static void main(String[] args) {

        String s1 = "abcde";
        String s2 = "ace";


        LCS demo = new LCS();
        System.out.println(demo.lcs(s1,s2));
    }


    public int lcs(String s1,String s2){
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <=m;i++){
            for (int j = 1; j <=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }


        }

        return dp[m][n];
    }
}
