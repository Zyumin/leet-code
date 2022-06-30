/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-08-19 12:46 AM
 */
public class StoI {
    public static void main(String[] args) {

        int min = Integer.MIN_VALUE;
        String a = "   -42";

        System.out.println(solution(a));
    }

    private static int solution(String a) {

        int aLength = a.length() - 1;

        int ans = 0;
        boolean negative = false;
        for (int index = 0; index <= aLength; index++) {
            char current = a.charAt(index);
            if (current == ' ') {
                continue;
            }

            if (current == '-') {
                negative = true;
                continue;
            }

            if (!Character.isDigit(current) && index == 0) {
                return 0;
            }

            if (!Character.isDigit(current) && index != 0) {
                return ans;
            }

            int temp = (current - '0') * (negative ? -1 : 1);
            if (negative) {
                //溢出检查
                if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && temp < Integer.MIN_VALUE % 10)) {
                    return 0;
                }
            } else {
                //溢出检查
                if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)) {
                    return 0;
                }
            }


            ans = ans * 10 + temp;
        }

        return ans;
    }
}
