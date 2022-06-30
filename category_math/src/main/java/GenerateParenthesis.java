import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-09-08 9:10 PM
 */
public class GenerateParenthesis {


    Set<String> list = new HashSet<>();

    public static void main(String[] args) {

        List<String> list = new GenerateParenthesis().generateParenthesis(4);

        for(String s:list){
            System.out.println(s);
        }


        System.out.println();
    }

    public List<String> generateParenthesis(int n) {

        char[] nums = new char[n * 2];

        for (int i = 0; i < n; i++) {
            nums[i] = '(';
            nums[n + i] = ')';
        }

//        for (char num : nums) {
//            System.out.println(num);
//        }
        backtrack(nums, new StringBuilder(), n * 2);


        return new ArrayList<>(list);


    }


    /**
     * 排列
     *
     * @param nums
     * @param track
     * @param k
     */
    public void backtrack(char[] nums, StringBuilder track, int k) {
        if (track.length() == k) {
            if (validateV2(track)) {
                list.add(track.toString());
            }

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            track.append(nums[i]);
            backtrack(nums, track, k);
            track.deleteCharAt(track.length() - 1);
        }
    }

    private boolean validate(StringBuilder track) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < track.length(); i++) {
            Character c = track.charAt(i);
            if (c.equals(')')) {
                if (!stack.isEmpty() && stack.peek().equals('(')) {
                    stack.pop();
                } else {
                    return false;
                }

            } else if (c.equals('(')) {
                stack.push(c);
            }

        }

        return stack.isEmpty();
    }

    public boolean validateV2(StringBuilder track) {
        int balance = 0;
        for (int i = 0; i < track.length(); i++) {
            Character c = track.charAt(i);
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }



    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }

            if (open < max) {
                cur.append('(');
                backtrack(ans, cur, open+1, close, max);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (close < open) {
                cur.append(')');
                backtrack(ans, cur, open, close+1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }

}
