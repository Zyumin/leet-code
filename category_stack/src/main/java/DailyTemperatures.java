import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author zhengyumin
 * @description :https://leetcode-cn.com/problems/daily-temperatures
 *
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。



 * @date 2020-07-16 4:26 PM
 */
public class DailyTemperatures {


    /**
     * 单调栈解法 :
     * 维护一个单调减的栈
     * 倒序入栈, while(当前值大于栈顶元素，出栈), 逻辑判断,入栈
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        solution(nums).stream().forEach(a-> System.out.println(a));
    }

    public static List solution(int[] nums){

        List<Integer> list = new ArrayList<>(nums.length);
        Stack<Integer> stack = new Stack<>();

        for(int i=nums.length-1;i>=0;i--){

            while(!stack.isEmpty()&& nums[stack.peek()]<=nums[i]){
                stack.pop();
            }

            list.add(stack.empty()?0:stack.peek()-i);
            stack.push(i);
        }

         Collections.reverse(list);
        return list;
    }
}
