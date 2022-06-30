/**
 * @author zhengyumin
 * @description A、B、C、D、E五个学校，已知e肯定不是第二名或第三名 , A说E是第一，B说B是第二，C说A是最差的，D说C不是最好的，E说D是最好的。只有第一和第二名说的是对的，其他说的都是错的，请编程确定五个学校的名次。
 * @date 2020-08-03 5:53 PM
 */
public class Qiongjv {

    public static void main(String[] args) {

        char[] arr = {'A', 'B', 'C', 'D', 'E'};
        permutation(arr, 0, 4);
    }

    public static void permutation(char[] s, int from, int to) {
        if (to <= 1) {
            return;
        }

        if (from == to) {
            int v = 0;
            String ans = new String(s);
            ans = "#" + ans;

            if (ans.indexOf('E') == 2 || ans.indexOf('E') == 3) {
                return;
            }
            if (ans.indexOf('E') == 1 && ans.indexOf('A') == 2) {
                v = v + 1;
            }

            if (ans.indexOf('B') == 1) {
                v = v + 1;
            }

            if ((ans.indexOf('C') == 1) || (ans.indexOf('C') == 2 - 1) && ans.indexOf('A') == 5) {
                v = v + 1;
            }

            if ((ans.indexOf('D') == 1) || (ans.indexOf('D') == 2) && ans.indexOf('C') != 1) {
                v = v + 1;
            }

            if ((ans.indexOf('E') == 1) || (ans.indexOf('E') == 2) && ans.indexOf('D') == 1) {
                v = v + 1;
            }
            if (v == 2) {
                System.out.println(ans);
            }
        } else {
            for (int i = from; i <= to; i++) {
                swap(s, i, from); //交换前缀，使其产生下一个前缀
                permutation(s, from + 1, to);
                swap(s, from, i); //将前缀换回，继续做上一个前缀的排列
            }
        }
    }

    public static void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
