import com.sun.tools.javac.util.ArrayUtils;
import com.sun.tools.javac.util.StringUtils;

import java.util.Arrays;

/**
 * @author zhengyumin
 * @description https://leetcode-cn.com/problems/multiply-strings
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * @date 2020-07-08 2:20 PM
 */
public class MultiplyStrings {

    /**
     * 解题思路 1.逆序遍历num1 和num2 模拟乘法运算 ，用数组存储
     *
     * @param args
     */
    public static void main(String[] args) {

        String num1 = "123";
        String num2 = "456";

        System.out.println(solution(num1, num2));


    }

    public static String solution(String num1, String num2) {
        //bad case
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }


        int []num = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int m1 = num2.charAt(j) - '0';

                int sum = n1*m1;
                sum+=num[i+j+1];

                num[i+j+1] = sum%10;
                num[i+j] += sum/10;
            }
        }

        StringBuilder builder = new StringBuilder();

        for(int i=0;i<num.length;i++){
            if (i == 0 && num[i] == 0) continue;
            builder.append(num[i]);
        }


        return builder.toString();
    }
}
