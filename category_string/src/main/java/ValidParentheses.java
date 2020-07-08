import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhengyumin
 * @description https://leetcode-cn.com/problems/valid-parentheses
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

 * @date 2020-07-08 12:25 PM
 */
public class ValidParentheses {

    /**
     * 方法一: 由于括号是需要连续的才算有效，所以遇到右括号时候，前一个必须是相同左括号 （利用栈  有效的括号弹出）
     * @param args
     */
    public static void main(String[] args) {

        String input = "{[]}";
        System.out.println(solution(input));


    }

    public static boolean solution(String input){

        Stack<Character> stack = new Stack<Character>();
        stack.push('#');
        //遇到右括号需要出栈
        Map<Character,Character> map = new HashMap<Character, Character>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        for(int i=0;i<input.length();i++){
            Character c = input.charAt(i);
            if(map.containsKey(c)){
                if(!stack.pop().equals(map.get(c))){
                    return  false;
                }
            }else{
                stack.push(c);
            }
        }

        return stack.pop().equals('#');

    }
}
