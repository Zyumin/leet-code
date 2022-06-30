import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengyumin
 * @descriptio 输入: S="ADOBECODEBANC" ,T="ABC"
 * 输出: "BANC"
 * 就是说要在S(source) 中找到包含T(target) 中全部字母的一个子串，且这个子串一定是所有可能子串中最短的。
 * @date 2020-10-14 9:24 PM
 */
public class No76_MinimumWindowSubstring {

    public static void main(String[] args) {
        String S = "AA", T = "AAC";
        No76_MinimumWindowSubstring demo = new No76_MinimumWindowSubstring();
        System.out.println(demo.solution(S, T));

    }

    public String solution(String s, String t) {

        //  key: 需要的词 value:需要出现的次数
        Map<Character, Integer> need = new HashMap<>();
        //  key: 需要的词 value:已经出现的次数
        Map<Character, Integer> windows = new HashMap<>();
        for (char a : t.toCharArray()) {
            need.put(a, need.getOrDefault(a, 0) + 1);
        }
        System.out.println(need);
        //已经满足的词个数
        int request = 0;

        int len = Integer.MAX_VALUE;
        int start = 0;

        int left = 0, right = 0;
        while (right < s.length()) {

            //扩大窗口
            char a = s.charAt(right);
            if (need.containsKey(a)) {
                windows.put(a, windows.getOrDefault(a, 0) + 1);
                if (windows.get(a).equals(need.get(a))) {
                    request++;
                }
            }
            System.out.println(windows+","+request);
            right++;

            while (request == need.size()) {
                //计算缩小窗口
                if (len > right - left) {
                    start = left;
                    len = right - left;
                }

                char b = s.charAt(left);
                left++;

                if (need.containsKey(b)) {
                    if(windows.get(b).equals(need.get(b))){
                        request--;
                    }
                    windows.put(b,windows.get(b)-1);
                }


            }

        }
        System.out.println(start+","+len);
        return len == Integer.MAX_VALUE ? "" : s.substring(start, len + start);


    }


}
