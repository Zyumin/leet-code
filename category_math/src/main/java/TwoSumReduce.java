/**
 * @author zhengyumin
 * @description 两数相减
 * @date 2020-08-18 11:56 PM
 */
public class TwoSumReduce {

    public static void main(String[] args) {

        String a = "123456";
        String b = "23";
        System.out.println(solution(a, b));
    }

    private static int solution(String a, String b) {

        int aLength = a.length() - 1;
        int bLength = b.length() - 1;

        StringBuilder result = new StringBuilder("");
        //数组存储或者字符串
        int carry = 0;
        while (bLength >= 0) {
            int x = a.charAt(aLength--)- '0' + carry - (b.charAt(bLength--) - '0') ;
            carry=0;
            if (x < 0) {
                carry = -1;
                x += 10;
            }
            result.insert(0, x);
//            aLength--;
//            bLength--;
        }

        while (aLength >= 0) {
            int x = a.charAt(aLength--) - '0' + carry;
            carry = 0;
            result.insert(0, x);
//            aLength--;
        }
        return Integer.valueOf(result.toString());
    }
}
