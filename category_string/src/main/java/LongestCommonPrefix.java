/**
 * @author zhengyumin
 * @description 链接：https://leetcode-cn.com/problems/longest-common-prefix
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。

 * @date 2020-07-07 7:24 PM
 */
public class LongestCommonPrefix {
    /**
     * 思路 方法一: 遍历   比较(L1,L2)公共前缀L 比较 L和L3
     * 方法二: 分治法
     *
     * @param args
     */
    public static void main(String[] args) {

        String[] input = {"flower", "flow", "flight"};
        System.out.println(solution(input));


    }


    public static String solution(String[] input) {

        //bad case
        if (input == null || input.length == 0) {

            return "";
        }

        String prefix = input[0];
        for (int i = 1; i < input.length; i++) {
            prefix = commonPrefix(prefix, input[i]);
            if (prefix.length() == 0) {
                break;
            }
        }

        return prefix;

    }


    public static String commonPrefix(String s1, String s2) {

        int min = Math.min(s1.length(), s2.length());
        int i = 0;
        for (; i < min; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
        }
        return s1.substring(0, i);

    }
}
