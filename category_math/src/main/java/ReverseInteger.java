/**
 * @author zhengyumin
 * @description : https://leetcode-cn.com/problems/reverse-integer
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *     示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @date 2020-07-08 6:14 PM
 */
public class ReverseInteger {

    /**
     * 解题思路:模仿数学的方式 反转数字,注意溢出判断
     *
     * @param args
     */
    public static void main(String[] args) {

        int input = 2147483612;
        System.out.println(solution(input));

    }

    public static int solution(int input) {
        //bad case
        if (input == 0) {
            return 0;
        }

        int ans = 0;
        while (input != 0) {
            //溢出判断
            int pop = input % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                return 0;
            }

            ans = ans * 10 + pop;
            input = input / 10;

        }


        return ans;
    }
}
