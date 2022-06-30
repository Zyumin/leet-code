import java.util.HashMap;

/**
 * @author zhengyumin
 * @description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * @date 2020-08-12 10:00 PM
 */
public class LongestSubstringWithoutRepeating {

    /**
     * 解法： 滑动窗口 先右指针扩大满足条件 再左指针缩小缩小满足条件，计算差值
     *
     * @param args
     */
    public static void main(String[] args) {
        String word = "abcabcbb";
//        String word = "baaaaaaab";
        System.out.println(solution1(word));
    }

    private static int solution(String word) {
//       char:index
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0;
        int size = word.length();
        for(int left = 0, right = 0;right<size;right++) {

            char a = word.charAt(right);
            //存在重复
            if(map.containsKey(a)){
                System.out.println(left+","+map.get(a));
                left = Math.max(left,map.get(a));
            }

            ans = Math.max(ans,right-left+1);
            map.put(a,right+1);

        }

        return ans;

    }

    private static int solution1(String word){
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0;

        for(int left=0,right=0;right<word.length();right++){
            char a = word.charAt(right);
            map.put(a,map.getOrDefault(a,0)+1);

            while(map.containsKey(a)&&map.get(a)>1){
                map.put(a,map.get(a)-1);
                left++;
            }

            ans = Math.max(ans,right-left+1);

        }
        return ans;
    }


}
