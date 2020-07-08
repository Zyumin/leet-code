/**
 * @author zhengyumin
 * @description
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

 *
 * @date 2020-07-07 3:52 PM
 */
public class LongestPalindrome {

    /**
     * 实现思路:
     * 1.双指针向两边展开（ 注意单数和复数）
     * 2.动态规划 P(i,j)=P(i+1,j−1)∧(Si ==Sj)
     * @param args
     */
    public static void main(String[] args) {

        String inputStr = "baabcd";


        System.out.println(solution(inputStr));

    }

    public static String solution(String s){
        //bad case
        if (s == null || s.length() < 1) {return "";}

        int start=0,end=0;
        for(int i =0;i<s.length();i++){
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int max = Math.max(len1,len2);
            if(max>end-start){
                start = i - (max-1)/2;
                end = i + max/2;
            }
        }
        return s.substring(start,end+1);
    }

    public static int expand(String source,int l,int r){
        while(l>=0&&r< source.length() && source.charAt(l)== source.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }

}
